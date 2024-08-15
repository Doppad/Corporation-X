package com.doppadecommerce.order;

import com.doppadecommerce.customer.CustomerClient;
import com.doppadecommerce.exeption.BusinessExeption;
import com.doppadecommerce.kafka.OrderConfirmation;
import com.doppadecommerce.kafka.OrderProducer;
import com.doppadecommerce.orderLine.OrderLineRequest;
import com.doppadecommerce.orderLine.OrderLineService;
import com.doppadecommerce.payment.PaymentClient;
import com.doppadecommerce.payment.PaymentRequest;
import com.doppadecommerce.product.ProductClient;
import com.doppadecommerce.product.PurchaseRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;
    public Integer createOrder(OrderRequest request) {
        // check the customer (have him or not) --> OpenFeign
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessExeption("Cannot create order:: No customer exists with the provided ID"));

        // purchase the products --> product-ms (RestTemplate)
        var purchasedProducts = this.productClient.purchaseProducts(request.products());

        // persist order
        var order = this.repository.save(mapper.toOrder(request));

        // persist order lines
        for (PurchaseRequest purchaseRequest: request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        // start payment process
        var paymentRequest = new PaymentRequest(
                request.amount(),
                request.paymentMethod(),
                order.getId(),
                order.getReference(),
                customer
        );
        paymentClient.requestOrderPayment(paymentRequest);

        //send the order configuration --> notification-ms (kafka)
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        return order.getId();
    }

    public List<OrderResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(Integer orderId) {
        return repository.findById(orderId)
                .map(mapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No order found with the provided ID: %d", orderId)));
    }
}

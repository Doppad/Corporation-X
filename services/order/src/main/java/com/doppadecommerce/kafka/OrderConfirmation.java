package com.doppadecommerce.kafka;

import com.doppadecommerce.customer.CustomerResponse;
import com.doppadecommerce.order.PaymentMethod;
import com.doppadecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

//information that we need to send to Kafka broker
public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {

}

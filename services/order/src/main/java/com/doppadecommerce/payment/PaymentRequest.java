package com.doppadecommerce.payment;

import com.doppadecommerce.customer.CustomerResponse;
import com.doppadecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(

        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}

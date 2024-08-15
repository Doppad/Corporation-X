package com.doppad.ecommerce.notification;

import com.doppad.ecommerce.payment.PaymentMethod;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;

import java.math.BigDecimal;

public record PaymentNotificationRequest(

        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstName,
        String customerLastName,
        String customerEmail
) {
}

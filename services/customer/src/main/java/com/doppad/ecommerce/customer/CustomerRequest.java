package com.doppad.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        String id,
        @NotNull(message = "Customer firstname is requared")
        String firstname,
        @NotNull(message = "Customer lastname is requared")
        String lastname,
        @NotNull(message = "Customer email is requared")
        @Email(message = "Customer email is not a valid email address")
        String email,
        Address address
) {
}

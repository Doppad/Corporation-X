package com.doppad.ecommerce.exeption;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerNotFoundExeption extends RuntimeException {
    private final String msg;
}

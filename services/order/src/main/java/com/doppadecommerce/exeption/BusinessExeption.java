package com.doppadecommerce.exeption;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessExeption extends RuntimeException {
    private final String msg;
}

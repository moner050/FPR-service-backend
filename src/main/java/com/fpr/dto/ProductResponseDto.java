package com.fpr.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductResponseDto<T> {
    int status;
    T data;

    public ProductResponseDto(T value, T i) {
    }
}

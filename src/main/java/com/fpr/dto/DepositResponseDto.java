package com.fpr.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DepositResponseDto<T> {
    int status;
    T data;

    public DepositResponseDto(T value, T i) {
    }
}

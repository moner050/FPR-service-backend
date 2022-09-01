package com.fpr.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SavingResponseDto<T> {
    int status;
    T data;

    public SavingResponseDto(T value, T i) {
    }
}

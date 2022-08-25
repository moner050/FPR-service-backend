package com.fpr.dto;

import com.fpr.domain.ExpiryDate;
import com.fpr.domain.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {

    private Long productId;
    private String savingsLimit;
    private String accountNumber;
    private float interestRate;
    private ExpiryDate date;
    private ProductType type;

}

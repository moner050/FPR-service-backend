package com.fpr.dto;

import com.fpr.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartResponseDto {

    private String korCoNm;
    private String finPrdtNm;
    private String mtrtInt;
    private Long maxLimit;

    public static CartResponseDto of(Product product) {
        return new CartResponseDto(product.getKorCoNm(),
                product.getFinPrdtNm(),
                product.getMtrtInt(),
                product.getMaxLimit());
    }
}

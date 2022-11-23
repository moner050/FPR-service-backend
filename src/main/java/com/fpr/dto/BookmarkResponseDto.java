package com.fpr.dto;

import com.fpr.domain.Product;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class BookmarkResponseDto {

    private String korCoNm;
    private String finPrdtNm;
    private String mtrtInt;
    private Long maxLimit;

    public static BookmarkResponseDto of(Product product) {
        return new BookmarkResponseDto (product.getKorCoNm(),
                product.getFinPrdtNm(),
                product.getMtrtInt(),
                product.getMaxLimit());
    }
}

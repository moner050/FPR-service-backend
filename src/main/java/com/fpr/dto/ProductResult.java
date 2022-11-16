package com.fpr.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductResult {
    private String prdt_div;
    private int total_count;
    List<ProductBaseListDto> baseList = new ArrayList<>();
    List<ProductOptionListDto> optionList = new ArrayList<>();
}

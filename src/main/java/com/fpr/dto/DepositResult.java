package com.fpr.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DepositResult {
    private int total_count;
    List<DepositBaseListDto> baseList = new ArrayList<>();
    List<DepositOptionListDto> optionList = new ArrayList<>();
}

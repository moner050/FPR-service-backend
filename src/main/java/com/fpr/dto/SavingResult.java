package com.fpr.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SavingResult {

    private int total_count;
    List<SavingBaseListDto> baseList = new ArrayList<>();
    List<SavingOptionListDto> optionList = new ArrayList<>();
}

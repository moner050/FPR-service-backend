package com.fpr.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PrtdDiv {
    S("S", "S"), D("D", "D");

    private String key;
    private String value;
}

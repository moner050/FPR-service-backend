package com.fpr.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ExpiryDate {
    ONEYEAR("1년"),
    TWOYEAR("2년"),
    THREEYEAR("3년"),
    FIVEYEAR("5년");

    private String krName;
    ExpiryDate(String krName) {
        this.krName = krName;
    }

    public String getKrName() {
        return krName;
    }
}

package com.fpr.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Deposit {

    @Id
    private Long id;
    private String dclsMonth;
    private String finCoNo;
    private String finPrdtCd;
    private String korCoNm;
    private String finPrdtNm;
    private String joinWay;
    private String mtrtInt;
    private String spclCnd;
    private String joinDeny;
    private String joinMember;
    private String etcNote;
    private Long maxLimit;
    private String dclsStrtDay;
    @Column(nullable = true)
    private String dclsEndDay;
    private String finCoSubmDay;

    private String img;

    private String intrRateType;
    private String intrRateTypeNm;
    private String saveTrm;
    private double intrRate;
    private double intrRate2;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    public void setProduct(Product product) {
        this.product = product;
    }

    @Builder
    private Deposit (Long id, String dclsMonth, String finCoNo, String finPrdtCd, String korCoNm, String finPrdtNm, String joinWay,
                     String mtrtInt, String spclCnd, String joinDeny, String joinMember, String etcNote, Long maxLimit, String dclsStrtDay,
                     String dclsEndDay, String finCoSubmDay, String img, String intrRateType, String intrRateTypeNm, String saveTrm, double intrRate, double intrRate2){
        this.id = id;
        this.dclsMonth = dclsMonth;
        this.finCoNo = finCoNo;
        this.finPrdtCd = finPrdtCd;
        this.korCoNm = korCoNm;
        this.finPrdtNm = finPrdtNm;
        this.joinWay = joinWay;
        this.mtrtInt = mtrtInt;
        this.spclCnd = spclCnd;
        this.joinDeny = joinDeny;
        this.joinMember = joinMember;
        this.etcNote = etcNote;
        this.maxLimit = maxLimit;
        this.dclsStrtDay = dclsStrtDay;
        this.dclsEndDay = dclsEndDay;
        this.finCoSubmDay = finCoSubmDay;
        this.img = img;
        this.intrRateType = intrRateType;
        this.intrRateTypeNm = intrRateTypeNm;
        this.saveTrm = saveTrm;
        this.intrRate = intrRate;
        this.intrRate2 = intrRate2;
    }

}

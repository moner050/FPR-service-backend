package com.fpr.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookmark_id")
    private Bookmark bookmark;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private String prdtDiv;

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
    private String rsrvType;
    private String rsrvTypeNm;
    private String saveTrm;
    private double intrRate;
    private double intrRate2;

    @Builder
    private Product (String prdtDiv, String dclsMonth, String finCoNo, String finPrdtCd, String korCoNm, String finPrdtNm, String joinWay,
                    String mtrtInt, String spclCnd, String joinDeny, String joinMember, String etcNote, Long maxLimit, String dclsStrtDay,
                    String dclsEndDay, String finCoSubmDay, String img, String intrRateType, String intrRateTypeNm, String rsrvType, String rsrvTypeNm, String saveTrm, double intrRate, double intrRate2){
        this.prdtDiv = prdtDiv;
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
        this.rsrvType = rsrvType;
        this.rsrvTypeNm = rsrvTypeNm;
        this.saveTrm = saveTrm;
        this.intrRate = intrRate;
        this.intrRate2 = intrRate2;
    }

    public void joinMember(Member member){
        this.member = member;
        this.member.addProduct(this);
    }

}

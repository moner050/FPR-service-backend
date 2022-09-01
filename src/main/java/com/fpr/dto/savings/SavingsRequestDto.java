package com.fpr.dto.savings;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fpr.domain.SavingsProduct;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.List;

@Getter @Setter
public class SavingsRequestDto {

    private Result result;

    @Getter @Setter
    public class Result {
        @Column(name = "prdt_div")
        private String prdtDiv;
        @Column(name = "total_coun")
        private String totalCount;
        @Column(name = "max_page_no")
        private String maxPageNo;
        @Column(name = "now_page_no")
        private String nowPageNo;
        @Column(name = "err_cd")
        private String errCd;
        @Column(name = "err_msg")
        private String errMsg;
        private List<SavingsRequestDto.BaseList> baseList;
        private List<SavingsRequestDto.OptionList> optionList;
    }

    @Getter @Setter
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class BaseList {
        @Column(name = "dcls_month")
        private String dclsMonth;
        @Column(name = "fin_co_no")
        private String finCoNo;
        @Column(name = "fin_prdt_cd")
        private String finPrdtCd;
        @Column(name = "kor_co_nm")
        private String korCoNm;
        @Column(name = "fin_prdt_nm")
        private String finPrdtNm;
        @Column(name = "join_way")
        private String joinWay;
        @Column(name = "mtrt_int")
        private String mtrtInt;
        @Column(name = "spcl_cnd")
        private String spclCnd;
        @Column(name = "join_deny")
        private String joinDeny;
        @Column(name = "join_member")
        private String joinMember;
        @Column(name = "etc_note")
        private String etcNote;
        @Column(name = "max_limi")
        private Long maxLimit;
        @Column(name = "dcls_strt_day")
        private String dclsStrtDay;
        @Column(name = "dcls_end_day")
        private String dclsEndDay;
        @Column(name = "fin_co_subm_day")
        private String finCoSubmDay;

        public SavingsProduct toEntity(){
            return SavingsProduct.builder()
                    .dclsMonth(dclsMonth)
                    .finCoNo(finCoNo)
                    .finPrdtCd(finPrdtCd)
                    .korCoNm(korCoNm)
                    .finPrdtNm(finPrdtNm)
                    .joinWay(joinWay)
                    .mtrtInt(mtrtInt)
                    .spclCnd(spclCnd)
                    .joinDeny(joinDeny)
                    .joinMember(joinMember)
                    .etcNote(etcNote)
                    .maxLimit(maxLimit)
                    .dclsStrtDay(dclsStrtDay)
                    .dclsEndDay(dclsEndDay)
                    .finCoSubmDay(finCoSubmDay)
                    .build();
        }

    }

    @Getter @Setter
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class OptionList {

        @Column(name = "intr_rate_type")
        private String intrRateType;
        @Column(name = "intr_rate_type_nm")
        private String intrRateTypeNm;
        @Column(name = "save_trm")
        private String saveTrm;
        @Column(name = "intr_rate")
        private double intrRate;
        @Column(name = "intr_rate2")
        private double intrRate2;

    }

}

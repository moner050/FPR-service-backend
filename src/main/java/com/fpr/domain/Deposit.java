package com.fpr.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Deposit {

    @Id
    private Long id;

    private String dcls_month;
    private String fin_co_no;
    private String fin_prdt_cd;
    private String kor_co_nm;
    private String fin_prdt_nm;
    private String join_way;
    private String mtrt_int;
    private String spcl_cnd;
    private String join_deny;
    private String join_member;
    private String etc_note;
    @Column(nullable = true)
    private Long max_limit;
    private String dcls_strt_day;
    @Column(nullable = true)
    private String dcls_end_day;
    private String fin_co_subm_day;

    private String intr_rate_type;
    private String intr_rate_type_nm;
    private String save_trm;
    private double intr_rate;
    private double intr_rate2;

    @Builder
    private Deposit (Long id, String dcls_month, String fin_co_no, String fin_prdt_cd, String kor_co_nm, String fin_prdt_nm, String join_way,
                     String mtrt_int, String spcl_cnd, String join_deny, String join_member, String etc_note, Long max_limit, String dcls_strt_day,
                     String dcls_end_day, String fin_co_subm_day, String intr_rate_type, String intr_rate_type_nm, String save_trm, double intr_rate, double intr_rate2){
        this.id = id;
        this.dcls_month = dcls_month;
        this.fin_co_no = fin_co_no;
        this.fin_prdt_cd = fin_prdt_cd;
        this.kor_co_nm = kor_co_nm;
        this.fin_prdt_nm = fin_prdt_nm;
        this.join_way = join_way;
        this.mtrt_int = mtrt_int;
        this.spcl_cnd = spcl_cnd;
        this.join_deny = join_deny;
        this.join_member = join_member;
        this.etc_note = etc_note;
        this.max_limit = max_limit;
        this.dcls_strt_day = dcls_strt_day;
        this.dcls_end_day = dcls_end_day;
        this.fin_co_subm_day = fin_co_subm_day;
        this.intr_rate_type = intr_rate_type;
        this.intr_rate_type_nm = intr_rate_type_nm;
        this.save_trm = save_trm;
        this.intr_rate = intr_rate;
        this.intr_rate2 = intr_rate2;
    }

}

package com.fpr.domain;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstallmentSavingsProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "isproductId")
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
    private Long max_limit;
    private String dcls_strt_day;
    private String dcls_end_day;
    private String fin_co_subm_day;

    private String intr_rate_type;
    private String intr_rate_type_nm;
    private String rsrv_type;
    private String rsrv_type_nm;
    private String save_trm;
    private double intr_rate;
    private double intr_rate2;

}

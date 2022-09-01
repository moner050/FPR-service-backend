package com.fpr;

import com.fpr.domain.Deposit;
import com.fpr.domain.Saving;
import com.fpr.dto.*;
import com.fpr.persistence.DepositRepository;
import com.fpr.persistence.SavingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class FprServiceBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FprServiceBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(DepositRepository depositRepository, SavingRepository savingRepository) {
        return (arg) -> {
            String url = "http://finlife.fss.or.kr/finlifeapi/depositProductsSearch.json";
            UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url)
                    .queryParam("auth", "41a94be07dfa9f03716566379d2d2371")
                    .queryParam("topFinGrpNo", "020000")
                    .queryParam("pageNo", 1).build();

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<DepositDto> DepositResponse = restTemplate.getForEntity(uriComponents.toString(), DepositDto.class);
            int cnt = DepositResponse.getBody().getResult().getTotal_count();

            List<DepositBaseListDto> depositBaseList = DepositResponse.getBody().getResult().getBaseList();
            List<DepositOptionListDto> depositOptionList = DepositResponse.getBody().getResult().getOptionList();

            for (int i = 0; i < cnt; i++) {
                Deposit deposit = Deposit.builder()
                        .id(Long.parseLong(String.valueOf(i)))
                        .dclsMonth(depositBaseList.get(i).getDcls_month())
                        .finCoNo(depositBaseList.get(i).getFin_co_no())
                        .finPrdtCd(depositBaseList.get(i).getFin_prdt_cd())
                        .korCoNm(depositBaseList.get(i).getKor_co_nm())
                        .finPrdtNm(depositBaseList.get(i).getFin_prdt_nm())
                        .joinWay(depositBaseList.get(i).getJoin_way())
                        .mtrtInt(depositBaseList.get(i).getMtrt_int())
                        .spclCnd(depositBaseList.get(i).getSpcl_cnd())
                        .joinDeny(depositBaseList.get(i).getJoin_deny())
                        .joinMember(depositBaseList.get(i).getJoin_member())
                        .etcNote(depositBaseList.get(i).getEtc_note())
                        .maxLimit(depositBaseList.get(i).getMax_limit())
                        .dclsStrtDay(depositBaseList.get(i).getDcls_strt_day())
                        .dclsStrtDay(depositBaseList.get(i).getDcls_end_day())
                        .finCoSubmDay(depositBaseList.get(i).getFin_co_subm_day())
                        .intrRateType(depositOptionList.get(i).getIntr_rate_type())
                        .intrRateTypeNm(depositOptionList.get(i).getIntr_rate_type_nm())
                        .saveTrm(depositOptionList.get(i).getSave_trm())
                        .intrRate(depositOptionList.get(i).getIntr_rate())
                        .intrRate2(depositOptionList.get(i).getIntr_rate2())
                        .build();

                depositRepository.save(deposit);
            }

            url = "http://finlife.fss.or.kr/finlifeapi/savingProductsSearch.json";
            uriComponents = UriComponentsBuilder.fromHttpUrl(url)
                    .queryParam("auth", "41a94be07dfa9f03716566379d2d2371")
                    .queryParam("topFinGrpNo", "020000")
                    .queryParam("pageNo", 1).build();

            restTemplate = new RestTemplate();
            ResponseEntity<SavingDto> SavingResponse = restTemplate.getForEntity(uriComponents.toString(), SavingDto.class);
            cnt = SavingResponse.getBody().getResult().getTotal_count();

            List<SavingBaseListDto> SavingBaseList = SavingResponse.getBody().getResult().getBaseList();
            List<SavingOptionListDto> SavingOptionList = SavingResponse.getBody().getResult().getOptionList();

            for (int i = 0; i < cnt; i++) {
                Saving saving = Saving.builder()
                        .id(Long.parseLong(String.valueOf(i)))
                        .dclsMonth(SavingBaseList.get(i).getDcls_month())
                        .finCoNo(SavingBaseList.get(i).getFin_co_no())
                        .finPrdtCd(SavingBaseList.get(i).getFin_prdt_cd())
                        .korCoNm(SavingBaseList.get(i).getKor_co_nm())
                        .finPrdtNm(SavingBaseList.get(i).getFin_prdt_nm())
                        .joinWay(SavingBaseList.get(i).getJoin_way())
                        .mtrtInt(SavingBaseList.get(i).getMtrt_int())
                        .spclCnd(SavingBaseList.get(i).getSpcl_cnd())
                        .joinDeny(SavingBaseList.get(i).getJoin_deny())
                        .joinMember(SavingBaseList.get(i).getJoin_member())
                        .etcNote(SavingBaseList.get(i).getEtc_note())
                        .maxLimit(SavingBaseList.get(i).getMax_limit())
                        .dclsStrtDay(SavingBaseList.get(i).getDcls_strt_day())
                        .dclsEndDay(SavingBaseList.get(i).getDcls_end_day())
                        .finCoSubmDay(SavingBaseList.get(i).getFin_co_subm_day())
                        .intrRateType(SavingOptionList.get(i).getIntr_rate_type())
                        .intrRateTypeNm(SavingOptionList.get(i).getIntr_rate_type_nm())
                        .rsrvType(SavingOptionList.get(i).getRsrv_type())
                        .rsrvTypeNm(SavingOptionList.get(i).getRsrv_type_nm())
                        .saveTrm(SavingOptionList.get(i).getSave_trm())
                        .intrRate(SavingOptionList.get(i).getIntr_rate())
                        .intrRate2(SavingOptionList.get(i).getIntr_rate2())
                        .build();

                savingRepository.save(saving);
            }
        };
    }
}

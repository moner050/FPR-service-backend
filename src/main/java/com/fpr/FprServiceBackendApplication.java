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
                        .dcls_month(depositBaseList.get(i).getDcls_month())
                        .fin_co_no(depositBaseList.get(i).getFin_co_no())
                        .fin_prdt_cd(depositBaseList.get(i).getFin_prdt_cd())
                        .kor_co_nm(depositBaseList.get(i).getKor_co_nm())
                        .fin_prdt_nm(depositBaseList.get(i).getFin_prdt_nm())
                        .join_way(depositBaseList.get(i).getJoin_way())
                        .mtrt_int(depositBaseList.get(i).getMtrt_int())
                        .spcl_cnd(depositBaseList.get(i).getSpcl_cnd())
                        .join_deny(depositBaseList.get(i).getJoin_deny())
                        .join_member(depositBaseList.get(i).getJoin_member())
                        .etc_note(depositBaseList.get(i).getEtc_note())
                        .max_limit(depositBaseList.get(i).getMax_limit())
                        .dcls_strt_day(depositBaseList.get(i).getDcls_strt_day())
                        .dcls_end_day(depositBaseList.get(i).getDcls_end_day())
                        .fin_co_subm_day(depositBaseList.get(i).getFin_co_subm_day())
                        .intr_rate_type(depositOptionList.get(i).getIntr_rate_type())
                        .intr_rate_type_nm(depositOptionList.get(i).getIntr_rate_type_nm())
                        .save_trm(depositOptionList.get(i).getSave_trm())
                        .intr_rate(depositOptionList.get(i).getIntr_rate())
                        .intr_rate2(depositOptionList.get(i).getIntr_rate2())
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
                        .dcls_month(SavingBaseList.get(i).getDcls_month())
                        .fin_co_no(SavingBaseList.get(i).getFin_co_no())
                        .fin_prdt_cd(SavingBaseList.get(i).getFin_prdt_cd())
                        .kor_co_nm(SavingBaseList.get(i).getKor_co_nm())
                        .fin_prdt_nm(SavingBaseList.get(i).getFin_prdt_nm())
                        .join_way(SavingBaseList.get(i).getJoin_way())
                        .mtrt_int(SavingBaseList.get(i).getMtrt_int())
                        .spcl_cnd(SavingBaseList.get(i).getSpcl_cnd())
                        .join_deny(SavingBaseList.get(i).getJoin_deny())
                        .join_member(SavingBaseList.get(i).getJoin_member())
                        .etc_note(SavingBaseList.get(i).getEtc_note())
                        .max_limit(SavingBaseList.get(i).getMax_limit())
                        .dcls_strt_day(SavingBaseList.get(i).getDcls_strt_day())
                        .dcls_end_day(SavingBaseList.get(i).getDcls_end_day())
                        .fin_co_subm_day(SavingBaseList.get(i).getFin_co_subm_day())
                        .intr_rate_type(SavingOptionList.get(i).getIntr_rate_type())
                        .intr_rate_type_nm(SavingOptionList.get(i).getIntr_rate_type_nm())
                        .rsrv_type(SavingOptionList.get(i).getRsrv_type())
                        .rsrv_type_nm(SavingOptionList.get(i).getRsrv_type_nm())
                        .save_trm(SavingOptionList.get(i).getSave_trm())
                        .intr_rate(SavingOptionList.get(i).getIntr_rate())
                        .intr_rate2(SavingOptionList.get(i).getIntr_rate2())
                        .build();

                savingRepository.save(saving);


            }
        };
    }
}

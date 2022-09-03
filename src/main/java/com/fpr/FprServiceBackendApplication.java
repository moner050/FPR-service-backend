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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableJpaAuditing
public class FprServiceBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FprServiceBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(DepositRepository depositRepository, SavingRepository savingRepository) {
        Map<String, String> bankImg = new HashMap<>();
        bankImg.put("하나은행", "https://blog.kakaocdn.net/dn/cdNxCH/btqyU8rQfKP/adu2Kzot3kNW5sK1r9ekd0/img.jpg");
        bankImg.put("부산은행", "https://blog.kakaocdn.net/dn/18TFu/btqyWKDIInm/GfE8079nzAF9txBlV71XS0/img.jpg");
        bankImg.put("대구은행", "https://blog.kakaocdn.net/dn/bRSnes/btqyUJMxks1/kGoKavqVJVmnhEaMa6KUc1/img.jpg");
        bankImg.put("전북은행", "https://blog.kakaocdn.net/dn/dknmzU/btqyWLJhKN8/t0CoaW62CqWJ177Kbh3RTk/img.jpg");
        bankImg.put("광주은행", "https://blog.kakaocdn.net/dn/EIul3/btqyUgw0VqP/MCSFlSakHSsccpZe8ED5Z0/img.jpg");
        bankImg.put("농협은행주식회사", "https://blog.kakaocdn.net/dn/bDOvRh/btqyXx4zjvs/gb3v21tHkeCYrozbCH0AYk/img.jpg");
        bankImg.put("신한은행", "https://blog.kakaocdn.net/dn/Iz97w/btqyXx4yZhO/3myJG9cf8ioKZ67PuYfeIK/img.jpg");
        bankImg.put("우리은행", "https://blog.kakaocdn.net/dn/qAwyo/btqyWLbmOAD/9eqyPAko6fuK9ycDeAcYrk/img.jpg");
        bankImg.put("한국씨티은행", "https://blog.kakaocdn.net/dn/elQtAQ/btqy0pll5Sc/075ww9VyvNCIjMkozDKJrK/img.jpg");
        bankImg.put("중소기업은행", "https://blog.kakaocdn.net/dn/Brop5/btqy0pZ3Nsp/ZpsMQnl64Uz0WQJjXXgI7k/img.jpg");
        bankImg.put("수협은행", "https://blog.kakaocdn.net/dn/biUvns/btqy5c7FDsu/lp1kKQHdGhF2ndix8is3z1/img.jpg");
        bankImg.put("MG새마을금고", "https://blog.kakaocdn.net/dn/boX3qv/btqAborY7n1/vzxDf2WePnGeQ9yyeVa2Rk/img.jpg");
        bankImg.put("국민은행", "https://blog.kakaocdn.net/dn/bYyqeR/btqwFAWAKWf/wXPLrundPBKPrhtXgr0Iv1/img.jpg");
        bankImg.put("전북은행", "https://blog.kakaocdn.net/dn/dknmzU/btqyWLJhKN8/t0CoaW62CqWJ177Kbh3RTk/img.jpg");
        bankImg.put("제주은행", "https://mblogthumb-phinf.pstatic.net/20121009_194/missalz_1349770609687eNbhs_JPEG/%C1%A6%C1%D6%C0%BA%C7%E0.jpg?type=w2");
        bankImg.put("주식회사 카카오뱅크", "http://www.kmug.co.kr/data/file/design/1846052894_Ro4E09x3_37ef10641c6c7ec089cf416f14db8309a2d9a97a.png");
        bankImg.put("주식회사 케이뱅크", "https://blog.kakaocdn.net/dn/b8fXYE/btrGFJqZ9KA/UI9QifuFq6kYFKIR4CL6s1/img.png");
        bankImg.put("토스뱅크 주식회사", "https://static.toss.im/assets/homepage/brand/img-press-bank.jpg");
        bankImg.put("한국산업은행", "https://blog.kakaocdn.net/dn/SMJ1N/btqDjHIMQ0r/jAKsKJ2lT2XhGiEIsvZGN0/img.jpg");
        bankImg.put("한국스탠다드차타드은행", "https://www.standardchartered.co.kr/np/assets/images/kr/base/210204_kr_sc_05.jpg");
        bankImg.put("경남은행", "https://www.knbank.co.kr/resource/img/bank_logo.jpg");

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
                String img = bankImg.get(depositBaseList.get(i).getKor_co_nm()) == null ? "" : bankImg.get(depositBaseList.get(i).getKor_co_nm());

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
                        .img(img)
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
                String img = bankImg.get(SavingBaseList.get(i).getKor_co_nm() == null ? "" : SavingBaseList.get(i).getKor_co_nm());

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
                        .img(img)
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

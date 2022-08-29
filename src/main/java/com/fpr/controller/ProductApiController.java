package com.fpr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpr.domain.Product;
import com.fpr.dto.ProductRequestDto;
import com.fpr.dto.property.BaseList;
import com.fpr.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ProductApiController {

    private final ProductService productService;

    @GetMapping("/api")
    public String callAPI(Product product) throws JsonProcessingException {

        HashMap<String, Object> result = new HashMap<>();

        String jsonInString = "";

        try {
            RestTemplate rt = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(headers);

            String url = "http://finlife.fss.or.kr/finlifeapi/depositProductsSearch.json";

            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url+"?"+"auth=41a94be07dfa9f03716566379d2d2371" + "&" + "topFinGrpNo=020000&pageNo=1").build();

            ResponseEntity<Map> resultMap = rt.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);
            result.put("statusCode", resultMap.getStatusCodeValue());
            result.put("header", resultMap.getHeaders());
            result.put("body", resultMap.getBody());

            LinkedHashMap bankResult = (LinkedHashMap) resultMap.getBody().get("result");
            ArrayList<Map> baseList = (ArrayList<Map>)bankResult.get("baseList");
            LinkedHashMap bnList = new LinkedHashMap<>();
            for (Map obj : baseList) {
                bnList.put(obj.get("fin_co_no"),obj.get("kor_co_nm"));
            }

            ObjectMapper mapper = new ObjectMapper();
            jsonInString = mapper.writeValueAsString(bnList);

            Product p = new Product();

        }catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body"  , e.getStatusText());
            System.out.println(e.toString());

        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "excpetion오류");
            System.out.println(e.toString());
        }



        return jsonInString;

    }

}

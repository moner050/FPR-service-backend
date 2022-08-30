package com.fpr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fpr.domain.SavingsProduct;
import com.fpr.service.SavingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SavingsApiController {

    private final SavingsService savingsService;

    @GetMapping("/product/list")
    public String findAll(Model model) {
        List<SavingsProduct> savingsProducts = savingsService.list();
        model.addAttribute("savingsProducts", savingsProducts);
        return "product/productList";
    }

    @GetMapping("/api")
    public String callAPI(SavingsProduct savingsProduct) throws JsonProcessingException {
        savingsService.apiSave(savingsProduct);
        return "/api";
    }

    @PostMapping("/product/detail")
    public String productDetail(Long sProductId, Model model) {
        model.addAttribute("savingsProducts", savingsService.findOne(sProductId));
        return "product/detail";
    }

    @PostMapping("/product/{id}")
    public String searchProduct(Model model, SavingsProduct savingsProduct) {
        model.addAttribute("searchProduct", savingsService.searchProduct(savingsProduct));
        return "product/searchproduct";
    }
}

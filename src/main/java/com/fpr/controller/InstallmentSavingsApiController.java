package com.fpr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fpr.domain.InstallmentSavingsProduct;
import com.fpr.domain.SavingsProduct;
import com.fpr.service.InstallmentSavingsService;
import com.fpr.service.SavingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InstallmentSavingsApiController {

    private final InstallmentSavingsService installmentSavingsService;

    @GetMapping("/product/list")
    public String findAll(Model model) {
        List<InstallmentSavingsProduct> installmentsavingsProducts = installmentSavingsService.list();
        model.addAttribute("installmentsavingsProducts", installmentsavingsProducts);
        return "product/productList";
    }

    @GetMapping("/api")
    public String callAPI(InstallmentSavingsProduct installmentsavingsProducts) throws JsonProcessingException {
        installmentSavingsService.apiSave(installmentsavingsProducts);
        return "/api";
    }

    @PostMapping("/product/detail")
    public String productDetail(Long isproductId, Model model) {
        model.addAttribute("installmentsavingsProducts", installmentSavingsService.findOne(isproductId));
        return "product/detail";
    }

    @PostMapping("/product/{id}")
    public String searchProduct(Model model, InstallmentSavingsProduct installmentsavingsProducts) {
        model.addAttribute("installmentsavingsProducts", installmentSavingsService.searchProduct(installmentsavingsProducts));
        return "product/searchproduct";
    }
}

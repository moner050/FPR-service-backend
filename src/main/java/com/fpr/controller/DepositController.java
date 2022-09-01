package com.fpr.controller;

import com.fpr.domain.Deposit;
import com.fpr.dto.DepositResponseDto;
import com.fpr.service.DepositService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepositController {

    private final DepositService depositService;

    @GetMapping("/product/list")
    public DepositResponseDto findAll(Model model) {
        List<Deposit> deposits = depositService.list();
        model.addAttribute("deposits", deposits);
        return new DepositResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PostMapping("/product/detail")
    public DepositResponseDto productDetail(Long id, Model model) {
        model.addAttribute("deposits", depositService.findOne(id));
        return new DepositResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PostMapping("/product/{id}")
    public DepositResponseDto searchProduct(Model model, Deposit deposit) {
        model.addAttribute("deposits", depositService.searchProduct(deposit));
        return new DepositResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}

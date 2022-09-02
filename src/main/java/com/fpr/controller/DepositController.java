package com.fpr.controller;

import com.fpr.domain.Deposit;
import com.fpr.dto.DepositResponseDto;
import com.fpr.service.DepositService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepositController {

    private final DepositService depositService;

    @GetMapping("/product/deposit/list")
    public ResponseEntity<List<Deposit>> depositAll() {
        List<Deposit> deposits = depositService.searchAll();
        return new ResponseEntity(deposits, HttpStatus.OK);
    }

    @PostMapping("/product/deposit/detail")
    public ResponseEntity<Deposit> depositDetail(Long id) {
        Deposit deposit = depositService.searchOne(id);
        return new ResponseEntity(deposit, HttpStatus.OK);
    }

    @PostMapping("/product/deposit/{korCoNm}")
    public ResponseEntity<List<Deposit>> depositSearch(@PathVariable("korCoNm") String korCoNm) {
        List<Deposit> deposits = depositService.searchProduct(korCoNm);
        return new ResponseEntity(deposits, HttpStatus.OK);
    }
}

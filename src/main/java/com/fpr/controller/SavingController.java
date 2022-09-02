package com.fpr.controller;

import com.fpr.domain.Deposit;
import com.fpr.domain.Saving;
import com.fpr.dto.SavingResponseDto;
import com.fpr.service.SavingService;
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
public class SavingController {

    private final SavingService savingService;

    @GetMapping("/product/saving/list")
    public ResponseEntity<List<Saving>> savingAll() {
        List<Saving> savings = savingService.searchAll();
        return new ResponseEntity(savings, HttpStatus.OK);
    }

    @PostMapping("/product/saving/detail")
    public ResponseEntity<Deposit> savingDetail(Long id) {
        Saving saving = savingService.searchOne(id);
        return new ResponseEntity(saving, HttpStatus.OK);
    }

    @PostMapping("/product/saving/{korCoNm}")
    public ResponseEntity<List<Saving>> savingSearch(@PathVariable("korCoNm") String korCoNm) {
        List<Saving> savings = savingService.searchProduct(korCoNm);
        return new ResponseEntity(savings, HttpStatus.OK);
    }
}

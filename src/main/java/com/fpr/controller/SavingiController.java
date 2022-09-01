package com.fpr.controller;

import com.fpr.domain.Saving;
import com.fpr.dto.SavingResponseDto;
import com.fpr.service.SavingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SavingiController {

    private final SavingService savingService;

    @GetMapping("/savingsproduct/list")
    public SavingResponseDto findAll(Model model) {
        List<Saving> savings = savingService.list();
        model.addAttribute("savings", savings);
        return new SavingResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PostMapping("/savingsproduct/detail")
    public SavingResponseDto productDetail(Long id, Model model) {
        model.addAttribute("saving", savingService.findOne(id));
        return new SavingResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PostMapping("/savingsproduct/{id}")
    public SavingResponseDto searchProduct(Model model, Saving saving) {
        model.addAttribute("saving", savingService.searchProduct(saving));
        return new SavingResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}

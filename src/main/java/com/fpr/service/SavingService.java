package com.fpr.service;

import com.fpr.domain.Deposit;
import com.fpr.domain.Saving;
import com.fpr.persistence.SavingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SavingService {

    private final SavingRepository savingRepository;

    public List<Saving> list(){
        return savingRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Saving searchOne(Long id) {
        Optional<Saving> product = savingRepository.findById(id);
        return product.orElseThrow(() -> new RuntimeException("검색된 제품이 없습니다"));
    }

    @Transactional
    public List<Saving> searchAll() {
        List<Saving> savings = savingRepository.findAll();
        if(savings.isEmpty()) throw new RuntimeException("검색된 제품이 없습니다");
        return savings;
    }

    public List<Saving> searchProduct(String korCoNm) {
        List<Saving> savings = savingRepository.findByKorCoNmContaining(korCoNm);
        if(savings.isEmpty()) throw new RuntimeException("검색된 제품이 없습니다");
        return savings;
    }
}

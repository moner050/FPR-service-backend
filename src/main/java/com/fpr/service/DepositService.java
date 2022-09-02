package com.fpr.service;

import com.fpr.domain.Deposit;
import com.fpr.persistence.DepositRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DepositService {

    private final DepositRepository depositRepository;

    @Transactional(readOnly = true)
    public List<Deposit> searchAll() {
        List<Deposit> deposit = depositRepository.findAll();
        if(deposit.isEmpty()) throw new RuntimeException("검색된 제품이 없습니다");
        return deposit;
    }

    @Transactional(readOnly = true)
    public Deposit searchOne(Long id) {
        Optional<Deposit> product = depositRepository.findById(id);
        return product.orElseThrow(() -> new RuntimeException("검색된 제품이 없습니다"));
    }

    @Transactional
    public List<Deposit> searchProduct(String korCoNm) {
        List<Deposit> deposit = depositRepository.findByKorCoNmContaining(korCoNm);
        if(deposit.isEmpty()) throw new RuntimeException("검색된 제품이 없습니다");
        return deposit;
    }

}

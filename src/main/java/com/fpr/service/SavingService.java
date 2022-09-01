package com.fpr.service;

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
    public Saving findOne(Long id) {
        Optional<Saving> product = savingRepository.findById(id);
        return product.orElseGet(() -> new Saving());
    }

//    public void recommendProduct(Member member) {
//        savingRepository.recommend(member.getAge(), member.getJob());
//    }

    public List<Saving> searchProduct(Saving savingsProduct) {
        return savingRepository.findBykorCoNm(savingsProduct.getKorCoNm());
    }
}

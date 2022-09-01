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

    public List<Deposit> list(){
        return depositRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Deposit findOne(Long id) {
        Optional<Deposit> product = depositRepository.findById(id);
        return product.orElseGet(() -> new Deposit());
    }

//    public void recommendProduct(Member member) {
//        depositRepository.recommend(member.getAge(), member.getJob());
//    }

    public List<Deposit> searchProduct(Deposit deposit) {
        return depositRepository.findBykorCoNm(deposit.getKorCoNm());
    }
}

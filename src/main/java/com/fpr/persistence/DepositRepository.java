package com.fpr.persistence;

import com.fpr.domain.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepositRepository extends JpaRepository<Deposit, Long> {

    List<Deposit> findByKorCoNmContaining(String korCoNm);
    Optional<Deposit> findById(Long id);
}

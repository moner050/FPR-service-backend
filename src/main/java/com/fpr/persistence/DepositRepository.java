package com.fpr.persistence;

import com.fpr.domain.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepositRepository extends JpaRepository<Deposit, Long> {

    List<Deposit> findBykorCoNm(String korCoNm);
}

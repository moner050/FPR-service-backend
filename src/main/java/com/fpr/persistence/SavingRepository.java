package com.fpr.persistence;

import com.fpr.domain.Deposit;
import com.fpr.domain.Saving;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SavingRepository extends JpaRepository<Saving, Long> {

    List<Saving> findByKorCoNmContaining(String korCoNm);
    Optional<Saving> findById(Long id);
}

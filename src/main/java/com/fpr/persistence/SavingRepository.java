package com.fpr.persistence;

import com.fpr.domain.Saving;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavingRepository extends JpaRepository<Saving, Long> {

    List<Saving> findBykorCoNm(String korCoNm);
}

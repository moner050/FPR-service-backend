package com.fpr.persistence;

import com.fpr.domain.InstallmentSavingsProduct;
import com.fpr.domain.Member;
import com.fpr.domain.SavingsProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstallmentSavingsRepository extends JpaRepository<InstallmentSavingsProduct, Long> {

    Member recommend(Integer age, String job);

    List<SavingsProduct> search(String kor_co_nm);
}

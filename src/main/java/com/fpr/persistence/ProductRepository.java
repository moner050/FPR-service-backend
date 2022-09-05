package com.fpr.persistence;

import com.fpr.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByKorCoNmContaining(String korCoNm);
    Optional<Product> findById(Long id);
}

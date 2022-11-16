package com.fpr.persistence;

import com.fpr.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // 전체 검색
    List<Product> findAll();

    // 은행명 검색
    List<Product> findByKorCoNmContaining(String korCoNm);
    // 은행 아이디로 검색
    Optional<Product> findById(Long id);
    // 가입방법 검색
    List<Product> findByJoinWayContaining(String joinWay);
    // 가입방법 검색
    List<Product> findByJoinWay(String joinWay);

    // 예적금 전체목록
    List<Product> findByPrdtDiv(String prdtDiv);
}

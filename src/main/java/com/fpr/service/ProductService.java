package com.fpr.service;

import com.fpr.domain.Product;
import com.fpr.persistence.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // 상품 정보
    @Transactional(readOnly = true)
    public Product searchOne(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new RuntimeException("검색된 제품이 없습니다"));
    }

    // 예적금 전체
    @Transactional
    public List<Product> searchAll() {
        List<Product> product = productRepository.findAll();
        if(product.isEmpty()) throw new RuntimeException("검색된 제품이 없습니다");
        return product;
    }

    // 예적금 전체 검색
    @Transactional
    public List<Product> searchProduct(String korCoNm) {
        List<Product> product = productRepository.findByKorCoNmContaining(korCoNm);
        if(product.isEmpty()) throw new RuntimeException("검색된 제품이 없습니다");
        return product;
    }

    // 예금 전체 목록
    @Transactional
    public List<Product> searchSavingAll() {
        List<Product> savings = productRepository.findByPrdtDiv(PrtdDiv.S.getKey());
        if(savings.isEmpty()) throw new RuntimeException("검색된 제품이 없습니다");
        return savings;
    }

    // 적금 전체 목록
    @Transactional
    public List<Product> searchDepositAll() {
        List<Product> deposits = productRepository.findByPrdtDiv(PrtdDiv.D.getKey());
        if(deposits.isEmpty()) throw new RuntimeException("검색된 제품이 없습니다");
        return deposits;
    }
}

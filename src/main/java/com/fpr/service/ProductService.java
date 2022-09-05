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

    private ProductRepository productRepository;

    public List<Product> list(){
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Product searchOne(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new RuntimeException("검색된 제품이 없습니다"));
    }

    @Transactional
    public List<Product> searchAll() {
        List<Product> savings = productRepository.findAll();
        if(savings.isEmpty()) throw new RuntimeException("검색된 제품이 없습니다");
        return savings;
    }

    public List<Product> searchProduct(String korCoNm) {
        List<Product> savings = productRepository.findByKorCoNmContaining(korCoNm);
        if(savings.isEmpty()) throw new RuntimeException("검색된 제품이 없습니다");
        return savings;
    }
}

package com.fpr.service;

import com.fpr.domain.Product;
import com.fpr.persistence.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findProduct(){
        return productRepository.findAll();
    }

    public void save(Product product) {

        productRepository.save(product);

    }

    public Optional findOne(Long productId) {
        return productRepository.findById(productId);
    }

    public void recommendProduct() {

    }

}

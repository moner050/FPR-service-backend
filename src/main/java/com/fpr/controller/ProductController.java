package com.fpr.controller;

import com.fpr.domain.Product;
import com.fpr.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // 예적금 전체
    @GetMapping("/products")
    public ResponseEntity<List<Product>> productAll() {
        List<Product> product = productService.searchAll();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // 상품 상세 정보
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> savingDetail(@PathVariable("id") Long id) {
        Product product = productService.searchOne(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // 예금 전체
    @GetMapping("/products/saving")
    public ResponseEntity<List<Product>> savingAll() {
        List<Product> product = productService.searchSavingAll();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // 적금 전체
    @GetMapping("/products/deposit")
    public ResponseEntity<List<Product>> depositAll() {
        List<Product> product = productService.searchDepositAll();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // 예적금 전체 검색
    @GetMapping("/products/{korCoNm}")
    public ResponseEntity<List<Product>> searchProducts(@PathVariable("korCoNm") String korCoNm) {
        List<Product> product = productService.searchProduct(korCoNm);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}

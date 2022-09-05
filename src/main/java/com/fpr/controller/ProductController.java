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

    @GetMapping("/product/saving/list")
    public ResponseEntity<List<Product>> savingAll() {
        List<Product> product = productService.searchAll();
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @PostMapping("/product/saving/detail")
    public ResponseEntity<Product> savingDetail(Long id) {
        Product product = productService.searchOne(id);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @PostMapping("/product/saving/{korCoNm}")
    public ResponseEntity<List<Product>> savingSearch(@PathVariable("korCoNm") String korCoNm) {
        List<Product> product = productService.searchProduct(korCoNm);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @GetMapping("/product/deposit/list")
    public ResponseEntity<List<Product>> depositAll() {
        List<Product> product = productService.searchAll();
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @PostMapping("/product/deposit/detail")
    public ResponseEntity<Product> depositDetail(Long id) {
        Product product = productService.searchOne(id);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @PostMapping("/product/deposit/{korCoNm}")
    public ResponseEntity<List<Product>> depositSearch(@PathVariable("korCoNm") String korCoNm) {
        List<Product> product = productService.searchProduct(korCoNm);
        return new ResponseEntity(product, HttpStatus.OK);
    }
}

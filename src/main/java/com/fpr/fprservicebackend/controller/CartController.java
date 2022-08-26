package com.fpr.fprservicebackend.controller;

import com.fpr.fprservicebackend.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    // 장바구니 담기
//    @PostMapping("/cart/{memberId}/{productId}")
//        public String addCart(@PathVariable Long memberId, @PathVariable Long productId) {
//
//        Member member = memberService.findById(memberId);
//        Product product = productService.findById(productId);
//
//        cartService.addCart(member, product);
//        return "";
//    }

    // 장바구니 목록



    // 장바구니 삭제
//    @DeleteMapping("/cart/{memberId}")
//    public String deleteAllCartItem(@PathVariable Long memberId) {
//      cartService.deleteAllCartItem(memberId);
//      return"";
//    }
}

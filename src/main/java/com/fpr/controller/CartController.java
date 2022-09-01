package com.fpr.controller;

import com.fpr.domain.CartItem;
import com.fpr.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    // 장바구니 담기
//    @PostMapping("/cart/{memberId}/{productId}")
//    public CartItem addCart(@PathVariable Long memberId, @PathVariable Long productId) {
//
//    }

    // 장바구니 목록 조회
    @GetMapping("/cart/{memberId}")
    public List<CartItem> getCartItemList(@PathVariable Long memberId) {
        return cartService.getCartItemList(memberId);
    }

    // 장바구니 삭제
    @DeleteMapping("/cart/{cartId}")
    public void deleteAllCartItem(@PathVariable Long cartId) {
      cartService.deleteAllCartItem(cartId);
    }
}

package com.fpr.controller;

import com.fpr.dto.CartResponseDto;
import com.fpr.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    // 장바구니 담기
    @PostMapping("/cart/{memberId}/{productId}")
    public ResponseEntity insertCart(@PathVariable Long memberId, @PathVariable Long productId) {
        cartService.insertCart(memberId, productId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    // 장바구니 삭제
    @DeleteMapping("/cart/{cartId}")
    public void deleteAllCartItem(@PathVariable Long cartId) {
      cartService.deleteAllCartItem(cartId);
    }

    // 장바구니 목록 조회
    @GetMapping("/cart/{cartId}")
    public ResponseEntity<CartResponseDto> cartList(@PathVariable("cartId") Long cartId) {
        return ResponseEntity.ok(cartService.getCartList(cartId));
    }
}

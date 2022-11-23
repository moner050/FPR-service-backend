package com.fpr.controller;

import com.fpr.dto.CartResponseDto;
import com.fpr.service.CartService;
import com.fpr.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    // 장바구니 목록 조회
    @GetMapping("/carts")
    public ResponseEntity<List<CartResponseDto>> cartList() {
        return ResponseEntity.ok(cartService.getCartList(SecurityUtil.getCurrentMemberId()));
    }

    // 장바구니 담기
    @PostMapping("/cart/{productId}")
    public ResponseEntity<Objects> insertCart(@PathVariable Long productId) {
        cartService.insertCart(SecurityUtil.getCurrentMemberId(), productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 장바구니 삭제
    @DeleteMapping("/carts")
    public void deleteAllCartItem() {
      cartService.deleteAllCartItem(SecurityUtil.getCurrentMemberId());
    }

    // 장바구니 단품 삭제
    @DeleteMapping("/cart/{cartItemId}")
    public void deleteCartItem(@PathVariable Long cartItemId) {
        cartService.deleteCartItem(SecurityUtil.getCurrentMemberId(), cartItemId);
    }
}

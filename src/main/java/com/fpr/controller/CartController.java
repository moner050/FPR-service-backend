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
//    public String addCart(@PathVariable Long memberId, @PathVariable Long productId) {
//
//        Member member = memberService.findById(memberId);
//        Product product = productService.findById(productId);
//
//        cartService.addCart(member, product);
//
//        return "";
//    }

    // 장바구니 목록
    @GetMapping("/cart/{memberId}")
    public List<CartItem> getCartItemList(@PathVariable Long memberId) {
        List<CartItem> cartItemList = cartService.getCartItemList(memberId);

    }


    // 장바구니 삭제
    @DeleteMapping("/cart/{cartId}")
    public void deleteAllCartItem(@PathVariable Long cartId) {
      cartService.deleteAllCartItem(cartId);
    }
}

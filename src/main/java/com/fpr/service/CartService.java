package com.fpr.service;

import com.fpr.domain.Cart;
import com.fpr.domain.CartItem;
import com.fpr.dto.CartDto;
import com.fpr.persistance.CartItemRepository;
import com.fpr.persistance.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
//    private final ProductRepository productRepository;

    // 장바구니 담기
//    @Transactional
//    public void addCart(Long memberId, Long productId) {
//        Cart cart = cartRepository.findByMemberId(memberId);
//
//        cartRepository.save();
//    }

    // 장바구니 목록
    public List<CartItem> getCartItemList(Long memberId) {

        List<CartItem> cartItems = cartItemRepository.findAll();

        return cartItems;
    }

    // 장바구니 삭제
    @Transactional
    public void deleteAllCartItem(Long cartId) {
        cartRepository.deleteById(cartId);
    }

}

package com.fpr.service;

import com.fpr.domain.Cart;
import com.fpr.domain.CartItem;
import com.fpr.persistance.CartItemRepository;
import com.fpr.persistance.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
//    private final ProductRepository productRepository;
//    private final MemberRepository memberRepository;

    // 장바구니 담기


    // 장바구니 목록 조회
    public List<CartItem> getCartItemList(Long memberId) {
        return cartItemRepository.findAllByMemberMemberId(memberId);
    }

    // 장바구니 삭제
    @Transactional
    public void deleteAllCartItem(Long cartId) {
        cartRepository.deleteById(cartId);
    }

}

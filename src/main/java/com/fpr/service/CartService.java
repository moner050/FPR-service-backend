package com.fpr.service;

import com.fpr.domain.Cart;
import com.fpr.domain.CartItem;
import com.fpr.domain.Member;
import com.fpr.domain.Product;
import com.fpr.dto.CartResponseDto;
import com.fpr.persistence.CartItemRepository;
import com.fpr.persistence.CartRepository;
import com.fpr.persistence.MemberRepository;
import com.fpr.persistence.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;

    // 장바구니 담기
    @Transactional
    public void insertCart(Long memberId ,Long productId){
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("검색된 제품이 없습니다."));
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("검색된 맴버가 없습니다."));

        Cart cart = cartRepository.findByMemberId(memberId)
                        .orElse(Cart.builder().member(member).build());

        CartItem cartItem = cartItemRepository.findByCartIdAndProductId(cart.getId(), productId)
                        .orElse(CartItem.builder().cart(cart).product(product).build());

        cartRepository.save(cart);
        cartItemRepository.save(cartItem);
    }

    // 장바구니 전체 삭제
    @Transactional
    public void deleteAllCartItem(Long memberId) {
        cartRepository.deleteByMemberId(memberId);
    }

    // 장바구니 단일 삭제
    @Transactional
    public void deleteCartItem(Long memberId, Long productId) {
        Cart cart = cartRepository.findByMemberId(memberId)
                .orElseThrow(() -> new RuntimeException("장바구니가 존재하지 않습니다."));

        CartItem cartItem = cartItemRepository.findByCartIdAndProductId(cart.getId(), productId)
                        .orElseThrow(() -> new RuntimeException("검색된 장바구니 목록이 없습니다."));

        cartItemRepository.delete(cartItem);
    }


    // 장바구니 목록 조회
    @Transactional(readOnly = true)
    public List<CartResponseDto> getCartList(Long memberId) {
        Cart cart = cartRepository.findByMemberId(memberId)
                .orElseThrow(() -> new RuntimeException("장바구니가 존재하지 않습니다."));

        List<Product> productList = cartItemRepository.findAllByCartId(cart.getId())
                .stream().map(CartItem::getProduct).collect(Collectors.toList());

        return productList.stream().map(CartResponseDto::of).collect(Collectors.toList());
    }
}

package com.fpr.service;

import com.fpr.domain.Cart;
import com.fpr.domain.Member;
import com.fpr.domain.Product;
import com.fpr.dto.CartResponseDto;
import com.fpr.persistence.CartRepository;
import com.fpr.persistence.MemberRepository;
import com.fpr.persistence.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;

    // 장바구니 담기
    @Transactional
    public void insertCart(Long memberId ,Long productId){
        Optional<Product> product = productRepository.findById(productId);
        Optional<Member> member = memberRepository.findById(memberId);

        product.orElseThrow(() -> new RuntimeException("검색된 제품이 없습니다."));
        member.orElseThrow(() -> new RuntimeException("검색된 맴버가 없습니다."));

        Optional<Cart> cart = cartRepository.findByCartId(memberId);
        if(!cart.isPresent()) {
                cart = Optional.of(new Cart());
        }

        cart.get().setCartId(memberId);
        cart.get().addProduct(product.get());

        CartResponseDto.of(cartRepository.save(cart.get()));
    }

    // 장바구니 삭제
    @Transactional
    public void deleteAllCartItem(Long cartId) {
        cartRepository.deleteById(cartId);
    }


    // 즐겨찾기 목록 조회
    @Transactional(readOnly = true)
    public CartResponseDto getCartList(Long cartId) {
        return cartRepository.findByCartId(cartId)
                .map(CartResponseDto::of)
                .orElseThrow(() -> new RuntimeException("즐겨찾기 목록이 없습니다."));
    }
}

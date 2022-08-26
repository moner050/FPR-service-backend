package com.fpr.fprservicebackend.service;

import com.fpr.fprservicebackend.domain.Cart;
import com.fpr.fprservicebackend.domain.CartItem;
import com.fpr.fprservicebackend.dto.CartDto;
import com.fpr.fprservicebackend.dto.CartItemDto;
import com.fpr.fprservicebackend.persistance.CartItemRepository;
import com.fpr.fprservicebackend.persistance.CartRepository;
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
//    public void addCart(CartItemDto cartItemDto, Long memberId) {

//        Cart cart = cartRepository.findByMemberId(memberId);

//        Product saveProduct = productRepository.findById(cartItemDto.getProductId());
//
//        CartItem savaCartItem = cartItemRepository.findByCartIdAndProductId(cart.getCartId(), product.getProductId());
//
//    }

    // 장바구니 목록
    public List<CartItem> memberCartItems(CartDto cartDto, Long memberId) {

        List<CartItem> cartItems = cartItemRepository.findAll();
        List<CartItem> memberItems = new ArrayList<>();

        for(CartItem cartItem : cartItems) {
            if(cartItem.getCart().getCartId() == cartDto.getCartId()) {
                memberItems.add(cartItem);
            }
        }
        return memberItems;
    }

    // 장바구니 삭제
//    @Transactional
//    public void deleteAllCartItem(Long memberId) {
//
//        List<CartItem> cartItems = cartItemRepository.findAll();
//
//        for (CartItem cartItem : cartItems) {
//            if(cartItem.getCart().getMember().getMemberId() == memberId){
//
//                cartItemRepository.deleteById(cartItem.getCartItemId());
//            }
//        }
//    }

}

package com.fpr.dto;

import com.fpr.domain.Cart;
import com.fpr.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartResponseDto {

    private List<Product> products = new ArrayList<>();

    public static CartResponseDto of(Cart cart) {
        return new CartResponseDto(cart.getProducts());
    }
}

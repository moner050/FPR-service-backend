package com.fpr.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @Column(name = "cartId")
    private Long cartId;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        this.products.add(product);
        if(product.getCart() != this){
            product.setCart(this);
        }
    }

    public void removeProduct(Product product){
        this.products.remove(product);
        if(product.getCart() != this){
            product.setCart(this);
        }
    }

}

package com.fpr.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookmark")
public class Bookmark {

    @Id
    @Column(name = "bookmark_id")
    private Long bookmarkId;

    @OneToMany(mappedBy = "bookmark",cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        this.products.add(product);
        if(product.getBookmark() != this){
            product.setBookmark(this);
        }
    }

    public void removeProduct(Product product){
        this.products.remove(product);
        if(product.getBookmark() != this){
            product.setBookmark(this);
        }
    }
}

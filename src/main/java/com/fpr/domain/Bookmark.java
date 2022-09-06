package com.fpr.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "bookmarkId")
    private Long bookmarkId;

    @OneToMany(mappedBy = "bookmark",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        this.products.add(product);
        if(product.getBookmark() != this){
            product.setBookmark(this);
        }
    }
}

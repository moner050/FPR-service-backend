package com.fpr.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Table(name = "member")
public class Member extends BaseTime{

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "job", nullable = false)
    private String job;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "authority", nullable = false)
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    @Builder
    private Member(String username, int age, String job, String email, String password, String phoneNumber, Authority authority) {
        this.username = username;
        this.age = age;
        this.job = job;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.authority = authority;
    }

    public void addProduct(Product product){
        this.products.add(product);
        if(product.getMember() != this){
            product.setMember(this);
        }
    }

}

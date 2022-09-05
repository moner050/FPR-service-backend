package com.fpr.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Deposit> deposits = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Saving> savings = new ArrayList<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public void addDeposit(Deposit deposit){
        this.deposits.add(deposit);
        if(deposit.getProduct() != this){
            deposit.setProduct(this);
        }
    }

    public void addSaving(Saving saving){
        this.savings.add(saving);
        if(saving.getProduct() != this){
            saving.setProduct(this);
        }
    }

    public void joinMember(Member member){
        this.member = member;
        this.member.addProduct(this);
    }

}

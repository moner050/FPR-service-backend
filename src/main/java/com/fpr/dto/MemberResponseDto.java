package com.fpr.dto;

import com.fpr.domain.Member;
import com.fpr.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDto {
    private String email;
    private String username;
    private int age;
    private String job;
    private String phoneNumber;
    private List<Product> products = new ArrayList<>();

    public static MemberResponseDto of(Member member) {
        return new MemberResponseDto(member.getEmail(), member.getUsername(), member.getAge(), member.getJob(), member.getPhoneNumber(), member.getProducts());
    }
}

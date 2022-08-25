package com.fpr.dto;

import com.fpr.domain.Member;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class MemberDto{

    @NotNull
    private String username;

    @NotNull
    @Size(min = 1, max = 200)
    private int age;

    @NotNull
    private String job;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String confirmPassword;

    @NotNull
    private String phoneNumber;

    public Member toEntity(){
        return Member.builder()
                .username(username)
                .age(age)
                .job(job)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .build();
    }
}

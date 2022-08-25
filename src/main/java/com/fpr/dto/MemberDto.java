package com.fpr.dto;

import com.fpr.domain.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {

    private Long memberId;

    private String username;

    private int age;

    private String job;

    private String email;

    private String password;

    private String birthday;

    public Member toEntity(){
        return Member.builder()
                .username(username)
                .email(email)
                .password(password)
                .age(age)
                .job(job)
                .birthday(birthday)
                .build();
    }

}

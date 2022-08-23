package com.fpr.fprservicebackend.dto;

import com.fpr.fprservicebackend.domain.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {

    private Long memberId;

    private String username;

    private String email;

    private String password;

    private String birthday;

    public Member toEntity(){
        return Member.builder()
                .username(username)
                .email(email)
                .password(password)
                .birthday(birthday)
                .build();
    }

}

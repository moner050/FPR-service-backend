package com.fpr.fprservicebackend.dto;

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

}

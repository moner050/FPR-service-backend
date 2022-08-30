package com.fpr.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LoginDto {

    @Email
    @NotNull
    private String email;

    @NotNull
    private String password;

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}

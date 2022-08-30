package com.fpr.dto;

import com.fpr.annotation.Tel;
import com.fpr.domain.Authority;
import com.fpr.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberRequestDto {
    // 계층간 이동시 데이터가 변조될 위험이 없이 하기위해 Setter 제거
    @NotNull
    private String username;

    @NotNull
    @Max(150)
    @Min(1)
    private Integer age;

    @NotNull
    private String job;

    @NotNull
    @Email(message = "유효하지 않은 이메일 형식입니다.")
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String confirmPassword;

    @NotNull
    @Tel
    private String phoneNumber;

    public Member toMember(PasswordEncoder passwordEncoder){
        return Member.builder()
                .username(username)
                .age(age)
                .job(job)
                .email(email)
                .password(passwordEncoder.encode(password))
                .phoneNumber(phoneNumber)
                .authority(Authority.ROLE_USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}

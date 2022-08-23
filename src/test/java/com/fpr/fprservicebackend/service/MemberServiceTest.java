package com.fpr.fprservicebackend.service;

import com.fpr.fprservicebackend.domain.Member;
import com.fpr.fprservicebackend.dto.MemberDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    @Transactional
    @DisplayName("회원가입 테스트")
    void 회원가입(){
        // given
        MemberDto memberDto = new MemberDto();
        memberDto.setEmail("test@naver.com");
        memberDto.setPassword("1234");
        memberDto.setUsername("테스트");
        memberDto.setBirthday("2022-04-07");

        // when
        memberService.insertMember(memberDto.toEntity());
        Member findMember = memberService.getMember("테스트");

        // then
        Assertions.assertThat(memberDto.getEmail()).isEqualTo(findMember.getEmail());
    }
}

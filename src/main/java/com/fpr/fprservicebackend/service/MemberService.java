package com.fpr.fprservicebackend.service;

import com.fpr.fprservicebackend.domain.Member;
import com.fpr.fprservicebackend.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private MemberRepository memberRepository;

    // 맴버 등록
    @Transactional
    public void insertMember(Member member){
        memberRepository.save(member);
    }

    // 맴버 조회
    @Transactional(readOnly = true)
    public Member getMember(String username) throws Exception {
        Optional<Member> getMember = memberRepository.findByUsername(username);
        return getMember.orElseThrow(() -> new Exception("맴버가 없습니다."));
    }

}

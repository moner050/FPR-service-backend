package com.fpr.controller;

import com.fpr.dto.MemberResponseDto;
import com.fpr.service.MemberService;
import com.fpr.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> getMyMemberInfo(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.getMyInfo(id));
    }

    @GetMapping("/me")
    public ResponseEntity<MemberResponseDto> getMyInfo() {
        return ResponseEntity.ok(memberService.getMyInfo(SecurityUtil.getCurrentMemberId()));
    }
}

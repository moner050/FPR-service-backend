package com.fpr.controller;

import com.fpr.dto.MemberResponseDto;
import com.fpr.service.MemberService;
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
}

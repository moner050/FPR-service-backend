package com.fpr.fprservicebackend.controller;

import com.fpr.fprservicebackend.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

}

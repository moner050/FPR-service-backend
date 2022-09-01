package com.fpr.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Slf4j
public class JwtTest {

    @Test
    @DisplayName("JWT 토큰 생성 테스트")
    public void createToken(){

        // Header
        Map<String, Object> headers = new HashMap<>();
        headers.put("alg", "HS256");
        headers.put("typ", "JWT");

        // Payload
        Map<String, Object> payloads = new HashMap<>();
        payloads.put("memberId", "1");
        payloads.put("age", 3);
        payloads.put("phoneNumber", "01033332222");

        // 토큰 유효시간
        Long expiredTime = 1000 * 60L * 60L * 1L;

        // 토큰 만료시간
        Date date = new Date();
        date.setTime(date.getTime() + expiredTime);

        // 시큐리티 키 생성
        Key key = Keys.hmacShaKeyFor("HelloWelcomeToMySecretKeyListIn20220827".getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        byte[] temp = key.getEncoded();

        log.info("알고리즘 방식 : " + key.getAlgorithm());
        log.info("포멧 방식 : " + key.getFormat());
        for (byte s : temp){
            sb.append(s + "");
        }
        log.info("변환된 바이트 형태 : " + sb);

        String jwt = Jwts.builder()
                .setHeader(headers)     // Headers 설정
                .setClaims(payloads)    // Payloads 설정
                .setSubject("테스트용도")     // 토큰 용도
                .setExpiration(date)    // 토큰 만료시간 설정
                .signWith(key, SignatureAlgorithm.HS256)    // 토큰 시큐리티 키 설정
                .compact();             // 토큰 생성

        log.info(jwt);
    }
}

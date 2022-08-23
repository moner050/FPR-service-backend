package com.fpr.fprservicebackend.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "job", nullable = false)
    private String job;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "birthday", nullable = false)
    private String birthday;

    @Builder
    private Member(String username, int age, String job, String email, String password, String birthday) {
        this.username = username;
        this.age = age;
        this.job = job;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
    }
}

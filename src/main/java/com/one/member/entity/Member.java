package com.one.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true, nullable = false)
    private String userId;
    @Column(unique = true, nullable = false)
    private String email; // 이메일

    private String name; // 이름
    @Column(unique = true, nullable = false)
    private String phone; // 전화번호

    private String password;

    private String zipcode; // 우편번호
    private String address1; // 주소1
    private String address2; // 주소2

    private String point; // 포인트

    private Role role; //권한


}

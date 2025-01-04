package com.one.member.repository;

import com.one.member.entity.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private EntityManager em;

    // 회원 가입
    public void save(Member member) {
        em.persist(member);
    }

    // 회원 아이디 찾기
    public Member findOne(Long userId) {
        return em.find(Member.class, userId);
    }

    // 모든 회원 정보 찾기
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();   // jpql. Entity 객체를 대상으로 쿼리를 날린다.
    }

    // 회원 이름 찾기
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

    // 아이디 중복검사
    public List<Member> findByUserId(String userId) {
        return em.createQuery("select m from Member m where m.userId = :userId", Member.class)
                .setParameter("userId", userId)
                .getResultList();
    }

}

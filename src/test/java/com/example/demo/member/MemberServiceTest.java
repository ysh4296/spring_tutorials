package com.example.demo.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();

    @Test
    void 회원가입() {
        Member member = new Member(1L, "실험체1", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        Assertions.assertThat(member).isEqualTo(findMember);
        System.out.println("테스트 통과");
    }
}

package com.example.demo.member;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberServiceTest {

    private MemberService memberService = new MemberServiceImpl();;

    @Test
    @DisplayName("회원가입 후 조회 시 동일한 회원이 반환되어야 한다")
    void 회원가입한다() {
        // given
        Member member = new Member(1L, "실험체1", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        assertThat(findMember)
                .as("가입된 회원과 조회된 회원이 일치해야 한다")
                .isEqualTo(member);
    }
}

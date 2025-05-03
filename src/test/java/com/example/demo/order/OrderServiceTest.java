package com.example.demo.order;

import com.example.demo.AppConfig;
import com.example.demo.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderServiceTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = ac.getBean("memberService", MemberService.class);
    OrderService orderService = ac.getBean("orderService", OrderService.class);

    @Test
    void 주문하기() {
        long memberId = 1L;
        Member member = new Member(memberId, "실험체1" , Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId,"USE", 24900);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2490);
    }
}

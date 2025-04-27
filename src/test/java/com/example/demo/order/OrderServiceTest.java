package com.example.demo.order;

import com.example.demo.AppConfig;
import com.example.demo.discount.DiscountPolicy;
import com.example.demo.discount.FixedDiscountPolicy;
import com.example.demo.discount.RateDiscountPolicy;
import com.example.demo.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    AppConfig appConfig = new AppConfig();
    private MemberService memberService = appConfig.memberService();
    private OrderService orderService = appConfig.orderService();

    @Test
    void 주문하기() {
        long memberId = 1L;
        Member member = new Member(memberId, "실험체1" , Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId,"USE", 24900);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2490);
    }
}

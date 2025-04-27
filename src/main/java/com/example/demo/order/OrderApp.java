package com.example.demo.order;

import com.example.demo.discount.DiscountPolicy;
import com.example.demo.discount.RateDiscountPolicy;
import com.example.demo.member.*;

public class OrderApp {
    public static void main(String[] args) {
        MemberRepository memberRepository = new MemoryMemberRepository();
        MemberService memberService = new MemberServiceImpl(memberRepository);
        DiscountPolicy discountPolicy = new RateDiscountPolicy();
        OrderService orderService = new OrderServiceImpl(memberRepository,discountPolicy);
        long memberId = 1L;
        Member member = new Member(memberId, "실험체1", Grade.BASIC);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "USB", 24900);
        System.out.println("order = " + order);
    }
}

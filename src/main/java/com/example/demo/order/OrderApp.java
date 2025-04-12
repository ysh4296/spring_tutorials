package com.example.demo.order;

import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        long memberId = 1L;
        Member member = new Member(memberId, "실험체1", Grade.BASIC);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "USB", 24900);
        System.out.println("order = " + order);
    }
}

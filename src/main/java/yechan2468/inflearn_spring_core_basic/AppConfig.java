package yechan2468.inflearn_spring_core_basic;

import yechan2468.inflearn_spring_core_basic.discount.DiscountPolicy;
import yechan2468.inflearn_spring_core_basic.discount.RateDiscountPolicy;
import yechan2468.inflearn_spring_core_basic.member.MemberRepository;
import yechan2468.inflearn_spring_core_basic.member.MemberService;
import yechan2468.inflearn_spring_core_basic.member.MemberServiceImpl;
import yechan2468.inflearn_spring_core_basic.member.MemoryMemberRepository;
import yechan2468.inflearn_spring_core_basic.order.OrderService;
import yechan2468.inflearn_spring_core_basic.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}

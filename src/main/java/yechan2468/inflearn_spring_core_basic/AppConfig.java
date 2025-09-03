package yechan2468.inflearn_spring_core_basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yechan2468.inflearn_spring_core_basic.discount.DiscountPolicy;
import yechan2468.inflearn_spring_core_basic.discount.RateDiscountPolicy;
import yechan2468.inflearn_spring_core_basic.member.MemberRepository;
import yechan2468.inflearn_spring_core_basic.member.MemberService;
import yechan2468.inflearn_spring_core_basic.member.MemberServiceImpl;
import yechan2468.inflearn_spring_core_basic.member.MemoryMemberRepository;
import yechan2468.inflearn_spring_core_basic.order.OrderService;
import yechan2468.inflearn_spring_core_basic.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}

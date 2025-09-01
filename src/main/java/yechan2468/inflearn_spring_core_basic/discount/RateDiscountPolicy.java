package yechan2468.inflearn_spring_core_basic.discount;

import yechan2468.inflearn_spring_core_basic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    @Override
    public int getDiscountAmount(Member member, int price) {
        return 0;
    }
}

package yechan2468.inflearn_spring_core_basic.discount;

import yechan2468.inflearn_spring_core_basic.member.Member;

public interface DiscountPolicy {

    /**
     *
     * @param member
     * @param price
     * @return 할인 대상 금액
     */
    int getDiscountAmount(Member member, int price);
}

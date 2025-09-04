package yechan2468.inflearn_spring_core_basic.discount;

import org.springframework.stereotype.Component;
import yechan2468.inflearn_spring_core_basic.annotation.SecondaryDiscountPolicy;
import yechan2468.inflearn_spring_core_basic.member.Grade;
import yechan2468.inflearn_spring_core_basic.member.Member;

@Component
@SecondaryDiscountPolicy
public class AmountDiscountPolicy implements DiscountPolicy {

    private final int discountAmount = 1000;

    @Override
    public int getDiscountAmount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountAmount;
        } else {
            return 0;
        }
    }
}

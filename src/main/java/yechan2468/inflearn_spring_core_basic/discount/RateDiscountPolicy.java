package yechan2468.inflearn_spring_core_basic.discount;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import yechan2468.inflearn_spring_core_basic.member.Grade;
import yechan2468.inflearn_spring_core_basic.member.Member;

@Component
@Primary
public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountPercent = 10;

    @Override
    public int getDiscountAmount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}

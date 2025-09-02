package yechan2468.inflearn_spring_core_basic.discount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import yechan2468.inflearn_spring_core_basic.AppConfig;
import yechan2468.inflearn_spring_core_basic.member.Grade;
import yechan2468.inflearn_spring_core_basic.member.Member;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy;

    @BeforeEach
    void beforeEach() {
        discountPolicy = new AppConfig().discountPolicy();
    }

    @Test
    @DisplayName("VIP는 10% 할인이 적용돼야 함")
    void vipDiscountTest() {
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        int discountAmount = discountPolicy.getDiscountAmount(memberA, 10000);

        assertThat(discountAmount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP 아니면 10% 할인 적용되지 않아야 함")
    void nonVipDiscountTest() {
        Member member = new Member(1L, "memberA", Grade.BASIC);
        int discountAmount = discountPolicy.getDiscountAmount(member, 10000);

        assertThat(discountAmount).isEqualTo(0);
    }
}
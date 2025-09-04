package yechan2468.inflearn_spring_core_basic.autowired;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yechan2468.inflearn_spring_core_basic.AutoAppConfig;
import yechan2468.inflearn_spring_core_basic.discount.DiscountPolicy;
import yechan2468.inflearn_spring_core_basic.member.Grade;
import yechan2468.inflearn_spring_core_basic.member.Member;

import java.util.List;
import java.util.Map;

public class AllMatchedBeanTest {

    @Test
    @DisplayName("타입에 해당하는 모든 빈 받기")
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        // 첫 번째 인자가 아닌 config를 받았을 때에는 아래와 같은 규칙을 따르는 것으로 보임
        DiscountService discountService = ac.getBean("allMatchedBeanTest.DiscountService", DiscountService.class);
        Member member = new Member(1L, "userA", Grade.VIP);

        int amountDiscount = discountService.getDiscountAmount(member, 20000, "amountDiscountPolicy");
        int rateDiscount = discountService.getDiscountAmount(member, 20000, "rateDiscountPolicy");

        System.out.println("amountDiscount = " + amountDiscount);
        System.out.println("rateDiscount = " + rateDiscount);
    }
    /*
    policyMap = {amountDiscountPolicy=yechan2468.inflearn_spring_core_basic.discount.AmountDiscountPolicy@3dd69f5a, rateDiscountPolicy=yechan2468.inflearn_spring_core_basic.discount.RateDiscountPolicy@3aa3193a}
    policies = [yechan2468.inflearn_spring_core_basic.discount.AmountDiscountPolicy@3dd69f5a, yechan2468.inflearn_spring_core_basic.discount.RateDiscountPolicy@3aa3193a]
    amountDiscount = 1000
    rateDiscount = 2000
     */

    private static class DiscountService {

        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;

            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int getDiscountAmount(Member member, int price, String discountStrategy) {
            DiscountPolicy discountPolicy = policyMap.get(discountStrategy);

            return discountPolicy.getDiscountAmount(member, price);
        }
    }
}

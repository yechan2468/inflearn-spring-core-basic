package yechan2468.inflearn_spring_core_basic.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import yechan2468.inflearn_spring_core_basic.discount.DiscountPolicy;
import yechan2468.inflearn_spring_core_basic.member.Member;
import yechan2468.inflearn_spring_core_basic.member.MemberRepository;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountAmount = discountPolicy.getDiscountAmount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountAmount);
    }
}

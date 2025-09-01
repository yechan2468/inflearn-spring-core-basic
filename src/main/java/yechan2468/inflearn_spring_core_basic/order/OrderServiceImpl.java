package yechan2468.inflearn_spring_core_basic.order;

import yechan2468.inflearn_spring_core_basic.discount.AmountDiscountPolicy;
import yechan2468.inflearn_spring_core_basic.discount.DiscountPolicy;
import yechan2468.inflearn_spring_core_basic.member.Member;
import yechan2468.inflearn_spring_core_basic.member.MemberRepository;
import yechan2468.inflearn_spring_core_basic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new AmountDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountAmount = discountPolicy.getDiscountAmount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountAmount);
    }
}

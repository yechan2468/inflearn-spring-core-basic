package yechan2468.inflearn_spring_core_basic.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yechan2468.inflearn_spring_core_basic.AppConfig;

public class MemberServiceTest {

    private MemberService memberService;

    @BeforeEach
    void beforeEach () {
        this.memberService = new AppConfig().memberService();
    }

    @Test
    void join() {
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member found = memberService.findMember(1L);

        // Junit이 아닌 assertj의 Assertions 사용
        //      isEqualTo: 해당 값이 같은지 비교. 객체가 비교 대상이 된다면 equals()와 같은 기능
        //      isSameAs: 참조 값이 같은지 확인
        Assertions.assertThat(member).isEqualTo(found);

    }
}

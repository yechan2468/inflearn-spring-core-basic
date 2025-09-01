package yechan2468.inflearn_spring_core_basic.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}

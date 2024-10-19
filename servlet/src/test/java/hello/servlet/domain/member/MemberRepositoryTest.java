package hello.servlet.domain.member;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member("hello", 20);
        Member saveMember = memberRepository.save(member);
        Member findMember = memberRepository.findById(saveMember.getId());

        Assertions.assertThat(saveMember.getId()).isEqualTo(findMember.getId());
    }

    @Test
    void findAll() {
        Member member = new Member("member1", 20);
        Member member1 = new Member("member2", 30);

        memberRepository.save(member);
        memberRepository.save(member1);

        List<Member> result = memberRepository.findAll();

        Assertions.assertThat(result).hasSize(2);
        Assertions.assertThat(result).contains(member, member1);
    }
}

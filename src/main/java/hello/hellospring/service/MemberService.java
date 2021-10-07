package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원X
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    // ctrl + alt + m // 메소드 따로 뽑기
    private void validateDuplicateMember(Member member) {
        // Optional<Member> result = memberRepository.findByName(member.getName()); // 이러면 안이쁨
        // Optional(Null 반환이 있을수도 있을경우 감싸는게 좋음)로 감싸져 있기때문에,
        // Optional 에 포함된 유용한 함수들로 한번 풀어준다.
        // 그냥 꺼내서 사용하고 싶으면 result.get();
        memberRepository.findByName(member.getName()) // return Optional<Member>
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원 조회
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

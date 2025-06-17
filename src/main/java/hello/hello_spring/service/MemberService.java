package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.repository.SpringDataJpaMemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service
//public class memberService(){
//
//}
@Service
@Transactional
public class MemberService {

    // private final MemoryMemberRepository repository  = new MemoryMemberRepository();
    private final SpringDataJpaMemberRepository repository;

    public MemberService(SpringDataJpaMemberRepository repository) {
        this.repository = repository;
    }

    //Member Join
    public Long memberJoin(Member member){
        Optional<Member> findMember = repository.findByName(member.getName());
        if(findMember.isEmpty()){
            repository.save(member);
            return member.getId();
        } else {
            throw new IllegalStateException("Duplicate Member");
        }
    }

    //Member List
    public List<Member> findMembers(){
        return repository.findAll();
    }

    //Find one Member
    public Optional<Member> findOne(Long memberId){
        return repository.findById(memberId);
    }

//    private void validateDuplicateMember(Member member) {
//        repository.findByName(member.getName())
//                .ifPresent(m -> {
//                    throw new IllegalStateException("이미 존재하는 회원입니다.");
//                });
//    }

}

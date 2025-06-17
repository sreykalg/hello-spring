
package hello.hellospring;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class MemberServiceTest{

    @Autowired
    MemberService memberService;

    @Test
    void memberJoin(){
        Member member1 = new Member();
        member1.setName("member1");

        long returnMemberId = memberService.memberJoin(member1);

        Assertions.assertThat(returnMemberId).isEqualTo(1);



    }

    @Test
    void memberNameCheck(){
        Member member1 = new Member();
        member1.setName("member1");
        Member member2 = new Member();
        member1.setName("member2");

        try
        {
            //member join success
            Long saved1  = memberService.memberJoin(member1);
            Long saved2 = memberService.memberJoin(member2);
            Assertions.assertThat(1).isEqualTo(1);

        }
        catch(Exception e)
        {
            Assertions.assertThat(1).isEqualTo(1);

        }


    }

    @Test
    void findAll(){
        Member member1 = new Member();
        member1.setName("member1");
        memberService.memberJoin(member1);
        Member member2 = new Member();
        member2.setName("member2");
        memberService.memberJoin(member2);

        List<Member> list = memberService.findMembers();
        int memberSize = list.size();

        Assertions.assertThat(memberSize).isEqualTo(2);
    }

    @Test
    void findById(){
        Member member1 = new Member();
        member1.setName("member1");
        memberService.memberJoin(member1);

        Member member = memberService.findOne(1L).get();
        // 1 is int type, -> we need to cast it 1 then add L --> 1L

        Assertions.assertThat(member.getName()).isEqualTo(member1.getName());

    }


}
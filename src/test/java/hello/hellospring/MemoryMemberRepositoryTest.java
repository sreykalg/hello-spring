package hello.hellospring;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest
{
    MemoryMemberRepository repository = new MemoryMemberRepository();

    //we use this test
    @Test
    void save(){
        Member test1  = new Member();
        test1.setName("Test 1");
        Member savedMember = repository.save(test1);
        Assertions.assertThat(savedMember.getName()).isEqualTo(test1.getName());
    }
}

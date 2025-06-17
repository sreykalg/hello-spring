package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import java.util.*;

public class MemoryMemberRepository implements MemberRepository
{
    private static final Map<Long, Member> store = new HashMap<>(); //Member data storage
    private static long sequence = 0L; //Member id

    @Override
    public Member save(Member member) {
        //In this case, address doesn't change, but data change
        sequence++;
        member.setId(sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.of(store.get(id));
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values()//Map values
                .stream() //Java stream function
                .filter(member -> member.getName().equals(name))
                .findAny(); // fetch data
        /*
          for (Map.Entry<Long, Member> entry : store.entrySet()) {
            Member member = entry.getValue();
            if(member.getName().equals(name)){
                return Optional.of(member);
            }
        }
        return Optional.empty();
         */
    }

    public void clearStore() {
        store.clear();
    }
}


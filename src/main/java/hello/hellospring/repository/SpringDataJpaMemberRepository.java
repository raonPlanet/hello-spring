package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepository {

    // JPDL select m from Member m where m.name = ?
    // 인터페이스 이름만으로도 개발이 해결된다.
    @Override
    Optional<Member> findByName(String name);


}

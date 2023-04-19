package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class,id);
        return Optional.of(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> results = em.createQuery("select m from Member m where m.name = :name",Member.class)
                .setParameter("name",name)
                .getResultList();
        return results.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // jpql 객체 언어
        return em.createQuery("select m from Member m",Member.class)
                 .getResultList();
    }
}

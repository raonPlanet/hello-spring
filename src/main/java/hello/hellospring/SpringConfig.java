package hello.hellospring;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;

    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {

        //return new MemoryMemberRepository();
//        return getJdbcMemberRepository();
//        return new JdbcMemberRepository((dataSource));
        return new JdbcTemplateMemberRepository(dataSource);
    }

    private JdbcMemberRepository getJdbcMemberRepository() {
        return new JdbcMemberRepository(dataSource);
    }
}
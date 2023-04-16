package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {


    private final MemberService memberService;
//    @Autowired private MemberService memberService; // 필드주입 비권장

//    @Autowired // setter주입 public 되어 외부 변경의 소지가 있다!!!
//    public void setMemberService(MemberService memberService) {
//
//        this.memberService = memberService;
//    }
    @Autowired
    public MemberController(MemberService memberService) {

        this.memberService = memberService;
    }
}

package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
        System.out.print("memberService = "+ memberService.getClass());
    }

    @GetMapping("/members/new")
    public String createdForm(){
        return "member/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){

        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = " + member.getName());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "member/memberList";
    }
}

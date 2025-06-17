package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    //testing to re- push on github

   private MemberService memberService;

    public HomeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/form")
    public String memberAddForm(){
        return "memberAddForm";

    }

    @PostMapping("/form")
    public String memberAddForm(
//            @RequestParam String name
            //name is refered to a name in html file
            //requesting data oe by one

            //or this if we alr created our own function file
            MemberAddForm memberAddForm
    ){
        System.out.println("name : " + memberAddForm.getName()); //to check
        Member member = new Member();
        member.setName(memberAddForm.getName());
        memberService.memberJoin(member);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Member> list= memberService.findMembers();
        model.addAttribute("list", list);
        return "memberList";

    }
}

package Wanted.Restful_API.controller;

import Wanted.Restful_API.dto.MemberDTO;
import Wanted.Restful_API.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/member/save")
    public String saveForm() {
        return "saveMember";
    }

    @PostMapping("/member/save")
    public String save(@Valid @ModelAttribute MemberDTO memberDTO) {

        memberService.save(memberDTO);
        return "/";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }
}

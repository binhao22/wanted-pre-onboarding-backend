package Wanted.Restful_API.controller;

import Wanted.Restful_API.dto.MemberDTO;
import Wanted.Restful_API.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> save(@Valid @ModelAttribute MemberDTO memberDTO) {

        memberService.save(memberDTO);
        return ResponseEntity.ok("회원가입 성공");
    }

    @GetMapping("/member/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/member/login")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok().body("token");
    }
}

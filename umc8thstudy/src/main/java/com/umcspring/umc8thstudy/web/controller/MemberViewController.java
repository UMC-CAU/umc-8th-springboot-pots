package com.umcspring.umc8thstudy.web.controller;

import com.umcspring.umc8thstudy.domain.Member;
import com.umcspring.umc8thstudy.service.MemberService.MemberCommandService;
import com.umcspring.umc8thstudy.web.dto.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MemberViewController {

    private final MemberCommandService memberCommandService;


    // thymeleaf 사용을 위해 일부가 변경되었습니다.
    // 실제로는 8주차에서 작성한 컨트롤러와 동일하게 작성하시면 됩니다!!
    @PostMapping("/members/signup")
    public String joinMember(@ModelAttribute("memberJoinDto") MemberRequestDTO.JoinDto request,
                             BindingResult bindingResult,
                             Model model) {

        System.out.println("=== 컨트롤러 진입 ===");
        System.out.println("Request: " + request);

        // 1. 바인딩 결과 상세 확인
        System.out.println("=== 바인딩 결과 확인 ===");
        System.out.println("hasErrors: " + bindingResult.hasErrors());

        if (bindingResult.hasErrors()) {
            System.out.println("=== 바인딩 에러 발생 ===");
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println("Error: " + error.toString());
            });
            return "signup";
        }

        // 2. 요청 데이터 상세 확인
        System.out.println("=== 요청 데이터 상세 ===");
        System.out.println("Name: " + request.getName());
        System.out.println("Email: " + request.getEmail());
        System.out.println("Address: " + request.getAddress());
        System.out.println("Phone: " + request.getPhoneAddress());
        System.out.println("Birth: " + request.getBirth());
        System.out.println("Gender: " + request.getGender());
        System.out.println("SocialType: " + request.getSocialType());
        System.out.println("Role: " + request.getRole());
        System.out.println("MemberPreferList: " + request.getMemberPreferList());
        System.out.println("MemberAgreeList: " + request.getMemberAgreeList());

        try {
            System.out.println("=== 서비스 메서드 호출 시작 ===");
            Member savedMember = memberCommandService.joinMember(request);
            System.out.println("=== 서비스 메서드 호출 완료 ===");
            System.out.println("저장된 회원 ID: " + savedMember.getId());
            return "redirect:/login";
        } catch (Exception e) {
            System.out.println("=== 예외 발생 ===");
            System.out.println("예외 타입: " + e.getClass().getSimpleName());
            System.out.println("예외 메시지: " + e.getMessage());
            e.printStackTrace();
            model.addAttribute("error", e.getMessage());
            return "signup";
        }
    }


    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("memberJoinDto", new MemberRequestDTO.JoinDto());
        return "signup";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}

package com.umcspring.umc8thstudy.web.controller;

import com.umcspring.umc8thstudy.apiPayload.ApiResponse;
import com.umcspring.umc8thstudy.converter.MemberConverter;
import com.umcspring.umc8thstudy.service.MemberService.MemberCommandService;
import com.umcspring.umc8thstudy.web.dto.MemberRequestDTO;
import com.umcspring.umc8thstudy.web.dto.MemberResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umcspring.umc8thstudy.domain.Member;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/login")
    @Operation(summary = "유저 로그인 API",description = "유저가 로그인하는 API입니다.")
    public ApiResponse<MemberResponseDTO.LoginResultDTO> login(@RequestBody @Valid MemberRequestDTO.LoginRequestDTO request) {
        return ApiResponse.onSuccess(memberCommandService.loginMember(request));
    }
}

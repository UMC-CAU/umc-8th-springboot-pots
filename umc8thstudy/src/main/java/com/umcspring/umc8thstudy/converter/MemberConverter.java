package com.umcspring.umc8thstudy.converter;

import com.umcspring.umc8thstudy.domain.Member;
import com.umcspring.umc8thstudy.domain.enums.Gender;
import com.umcspring.umc8thstudy.domain.enums.MemberStatus;
import com.umcspring.umc8thstudy.domain.enums.SocialType;
import com.umcspring.umc8thstudy.web.dto.MemberRequestDTO;
import com.umcspring.umc8thstudy.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request) {
        Gender gender = parseGender(request.getGender());
        SocialType socialType = parseSocialType(request.getSocialType());

        return Member.builder()
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .password(request.getPassword())
                .phoneAddress(request.getPhoneAddress())
                .birth(request.getBirth())
                .gender(gender)
                .socialType(socialType)
                .status(MemberStatus.ACTIVE)
                .role(request.getRole())
//                .score(request.getScore())
                .memberPreferList(new ArrayList<>())
                .memberAgreeList(new ArrayList<>())
                .build();
    }


    public static MemberResponseDTO.MemberInfoDTO toMemberInfoDTO(Member member) {
        return MemberResponseDTO.MemberInfoDTO.builder()
                .name(member.getName())
                .email(member.getEmail())
                .gender(member.getGender().name())
                .build();
    }

    public static MemberResponseDTO.LoginResultDTO toLoginResultDTO(Long memberId, String accessToken) {
        return MemberResponseDTO.LoginResultDTO.builder()
                .memberId(memberId)
                .accessToken(accessToken)
                .build();
    }

    private static Gender parseGender(String value) {
        try {
            return Gender.valueOf(value.toUpperCase());
        } catch (Exception e) {
            return Gender.NONE;
        }
    }

    private static SocialType parseSocialType(String value) {
        try {
            return SocialType.valueOf(value.toUpperCase());
        } catch (Exception e) {
            return null;
        }
    }


}
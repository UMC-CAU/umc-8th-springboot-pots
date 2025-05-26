package com.umcspring.umc8thstudy.web.controller;

import com.umcspring.umc8thstudy.apiPayload.ApiResponse;
import com.umcspring.umc8thstudy.domain.Member;
import com.umcspring.umc8thstudy.domain.Mission;
import com.umcspring.umc8thstudy.service.MissionService.MissionService;
import com.umcspring.umc8thstudy.web.dto.MemberMissionRequestDTO;
import com.umcspring.umc8thstudy.web.dto.MemberMissionResponseDTO;
import com.umcspring.umc8thstudy.web.dto.MissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {
    private final MissionService missionService;

    @PostMapping("/store")
    public ApiResponse<String> assignMissionToStore(@RequestBody MissionRequestDTO.addMission request) {
        missionService.assignMissionToStore(request);

        return ApiResponse.onSuccess("미션이 할당되었습니다.");
    }


    @PostMapping("member")
    public ApiResponse<MemberMissionResponseDTO> assignMissionToUser(@RequestBody MemberMissionRequestDTO request) {
        MemberMissionResponseDTO response = missionService.assignMissionToUser(request);
        return ApiResponse.onSuccess(response);
    }
}

package com.umcspring.umc8thstudy.service.MissionService;

import com.umcspring.umc8thstudy.apiPayload.code.BaseErrorCode;
import com.umcspring.umc8thstudy.apiPayload.code.status.ErrorStatus;
import com.umcspring.umc8thstudy.apiPayload.exception.handler.TempHandler;
import com.umcspring.umc8thstudy.domain.Member;
import com.umcspring.umc8thstudy.domain.Mission;
import com.umcspring.umc8thstudy.domain.Store;
import com.umcspring.umc8thstudy.domain.enums.MissionState;
import com.umcspring.umc8thstudy.domain.mapping.MemberMission;
import com.umcspring.umc8thstudy.repository.MemberMissionRepository;
import com.umcspring.umc8thstudy.repository.MemberRepository;
import com.umcspring.umc8thstudy.repository.MissionRepository;
import com.umcspring.umc8thstudy.repository.StoreRepository.StoreRepository;
import com.umcspring.umc8thstudy.web.dto.MemberMissionRequestDTO;
import com.umcspring.umc8thstudy.web.dto.MemberMissionResponseDTO;
import com.umcspring.umc8thstudy.web.dto.MissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    public void assignMissionToStore(MissionRequestDTO.addMission missionRequestDTO) {
        //미션 가게 조회 예외처리
        Mission mission = missionRepository.findById(missionRequestDTO.getId())
                .orElseThrow(() -> new TempHandler(ErrorStatus.MISSION_NOT_FOUND));
        Store store = storeRepository.findById(missionRequestDTO.getStoreId())
                .orElseThrow(() -> new TempHandler(ErrorStatus.STORE_NOT_FOUND));

        //연관관계
        mission.assignMission(store);

    }


    public MemberMissionResponseDTO assignMissionToUser(MemberMissionRequestDTO request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new TempHandler(ErrorStatus.MISSION_NOT_FOUND));

        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .state(MissionState.PROGRESS)
                .deadline(LocalDateTime.now().plusDays(7))  // 예시: 7일 후 마감
                .build();

        memberMissionRepository.save(memberMission);

        return new MemberMissionResponseDTO(
                memberMission.getId(),
                member.getId(),
                mission.getId(),
                memberMission.getState().name(),
                memberMission.getDeadline()
        );
    }
}

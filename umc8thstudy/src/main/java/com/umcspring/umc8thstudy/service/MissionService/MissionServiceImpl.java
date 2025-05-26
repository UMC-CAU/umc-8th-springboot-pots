package com.umcspring.umc8thstudy.service.MissionService;

import com.umcspring.umc8thstudy.apiPayload.code.BaseErrorCode;
import com.umcspring.umc8thstudy.apiPayload.code.status.ErrorStatus;
import com.umcspring.umc8thstudy.apiPayload.exception.handler.TempHandler;
import com.umcspring.umc8thstudy.domain.Mission;
import com.umcspring.umc8thstudy.domain.Store;
import com.umcspring.umc8thstudy.repository.MissionRepository;
import com.umcspring.umc8thstudy.repository.StoreRepository.StoreRepository;
import com.umcspring.umc8thstudy.web.dto.MissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    public void assignMissionToStore(MissionRequestDTO.addMission missionRequestDTO) {
        //미션 가게 조회 예외처리
        Mission mission = missionRepository.findById(missionRequestDTO.getId())
                .orElseThrow(() -> new TempHandler(ErrorStatus.MISSION_NOT_FOUND));
        Store store = storeRepository.findById(missionRequestDTO.getStoreId())
                .orElseThrow(() -> new TempHandler(ErrorStatus.STORE_NOT_FOUND));

        //연관관계
        mission.assignMission(store);

    }
}

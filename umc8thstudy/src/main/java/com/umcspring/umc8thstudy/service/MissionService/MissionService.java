package com.umcspring.umc8thstudy.service.MissionService;

import com.umcspring.umc8thstudy.web.dto.MemberMissionRequestDTO;
import com.umcspring.umc8thstudy.web.dto.MemberMissionResponseDTO;
import com.umcspring.umc8thstudy.web.dto.MissionRequestDTO;

public interface MissionService {

    void assignMissionToStore(MissionRequestDTO.addMission missionRequestDTO);

    MemberMissionResponseDTO assignMissionToUser(MemberMissionRequestDTO request);

    }

package com.umcspring.umc8thstudy.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberMissionRequestDTO {

    private Long memberId;
    private Long missionId;
}

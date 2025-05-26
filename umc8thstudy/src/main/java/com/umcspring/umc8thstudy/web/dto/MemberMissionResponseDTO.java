package com.umcspring.umc8thstudy.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberMissionResponseDTO {
    private Long id;
    private Long memberId;
    private Long missionId;
    private String state;
    private LocalDateTime deadline;
}

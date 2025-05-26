package com.umcspring.umc8thstudy.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MissionRequestDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addMission{
        private Long id;
        private String content;
        private Integer missionPoint;
        private Integer pay;
        private Long storeId;
    }
}

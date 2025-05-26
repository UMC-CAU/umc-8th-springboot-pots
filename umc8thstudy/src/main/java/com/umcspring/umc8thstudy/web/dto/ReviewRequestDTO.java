package com.umcspring.umc8thstudy.web.dto;

import lombok.Getter;

@Getter
public class ReviewRequestDTO {

    private Long memberId;
    private Long storeId;
    private Float score;
    private String content;
}

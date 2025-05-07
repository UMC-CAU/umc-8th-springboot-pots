package com.umcspring.umc8thstudy.domain;

import com.umcspring.umc8thstudy.domain.common.BaseEntity;
import com.umcspring.umc8thstudy.domain.mapping.MemberMission;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Point extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer points;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_missions_id")
    private MemberMission memberMission;

    //적립날짜를 따로 만들필요가 없네
}
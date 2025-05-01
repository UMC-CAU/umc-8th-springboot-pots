package com.umcspring.umc8thstudy.domain.mapping;

import com.umcspring.umc8thstudy.domain.Member;
import com.umcspring.umc8thstudy.domain.Mission;
import com.umcspring.umc8thstudy.domain.common.BaseEntity;
import com.umcspring.umc8thstudy.domain.enums.MissionState;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionState state;

    private LocalDateTime deadline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

}

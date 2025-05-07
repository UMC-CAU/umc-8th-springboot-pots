package com.umcspring.umc8thstudy.domain;

import com.umcspring.umc8thstudy.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import com.umcspring.umc8thstudy.domain.enums.TermType;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Term extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(length = 20)
    private String version;

    @Enumerated(EnumType.STRING)
    private TermType type;

}

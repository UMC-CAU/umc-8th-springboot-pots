package com.umcspring.umc8thstudy.domain;

import com.umcspring.umc8thstudy.domain.common.BaseEntity;
import com.umcspring.umc8thstudy.domain.enums.Gender;
import com.umcspring.umc8thstudy.domain.enums.MemberStatus;
import com.umcspring.umc8thstudy.domain.enums.Role;
import com.umcspring.umc8thstudy.domain.enums.SocialType;
import com.umcspring.umc8thstudy.domain.mapping.MemberAgree;
import com.umcspring.umc8thstudy.domain.mapping.MemberMission;
import com.umcspring.umc8thstudy.domain.mapping.MemberPrefer;
import com.umcspring.umc8thstudy.domain.Notification;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 40)
    private String phoneAddress;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "social_type", length = 20)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    private LocalDate inactiveDate;


    @Enumerated(EnumType.STRING)
    private Role role;

    //점수
    @ColumnDefault("0")
    private Integer score;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Notification> notificationList = new ArrayList<>();

    public void addAll(List<MemberPrefer> prefers) {
        this.memberPreferList.addAll(prefers);
    }

    public void encodePassword(String password) {
        this.password = password;
    }
}
package com.umcspring.umc8thstudy.domain;

import com.umcspring.umc8thstudy.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //별점
    private Float score;

    //리뷰내용인것임
    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewImage> images = new ArrayList<>();

    //연관관계 편의메서드
    public void assignMember(Member member){
        this.member = member;
        if(!member.getReviewList().contains(this)){
            member.getReviewList().add(this);
        }
    }
    public void assignStore(Store store){
        this.store = store;
        if(!store.getReviews().contains(this)){
            store.getReviews().add(this);
        }
    }
}

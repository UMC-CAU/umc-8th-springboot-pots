package com.umcspring.umc8thstudy.service.ReviewService;

import com.umcspring.umc8thstudy.apiPayload.ApiResponse;
import com.umcspring.umc8thstudy.apiPayload.code.status.ErrorStatus;
import com.umcspring.umc8thstudy.apiPayload.exception.handler.TempHandler;
import com.umcspring.umc8thstudy.domain.Member;
import com.umcspring.umc8thstudy.domain.Review;
import com.umcspring.umc8thstudy.domain.Store;
import com.umcspring.umc8thstudy.repository.MemberRepository;
import com.umcspring.umc8thstudy.repository.ReviewRepository;
import com.umcspring.umc8thstudy.repository.StoreRepository.StoreRepository;
import com.umcspring.umc8thstudy.web.dto.ReviewRequestDTO;
import com.umcspring.umc8thstudy.web.dto.ReviewResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;


    @Transactional
    public ReviewResponseDTO.ReviewPreViewDTO writeReview(ReviewRequestDTO.ReviewWrite request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new TempHandler(ErrorStatus.STORE_NOT_FOUND));

        Review review = Review.builder()
                .member(member)
                .store(store)
                .score(request.getScore())
                .content(request.getContent())
                .build();
        review.assignMember(review.getMember());
        reviewRepository.save(review);
        ReviewResponseDTO.ReviewPreViewDTO response = ReviewResponseDTO.ReviewPreViewDTO.builder()
                .memberNickname(member.getName())
                .storeId(request.getStoreId())
                .score(request.getScore())
                .content(request.getContent())
                .build();

        return response;
    }

    public Page<Review> getMemberReview(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Page<Review> ReviewPage = reviewRepository.findByMember(member, PageRequest.of(page, 10));

        return ReviewPage;

    }
}

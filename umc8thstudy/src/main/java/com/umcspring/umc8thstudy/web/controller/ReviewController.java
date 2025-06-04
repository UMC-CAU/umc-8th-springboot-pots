package com.umcspring.umc8thstudy.web.controller;

import com.umcspring.umc8thstudy.apiPayload.ApiResponse;
import com.umcspring.umc8thstudy.domain.Review;
import com.umcspring.umc8thstudy.service.ReviewService.ReviewService;
import com.umcspring.umc8thstudy.web.dto.ReviewRequestDTO;
import com.umcspring.umc8thstudy.web.dto.ReviewResponseDTO;
import com.umcspring.umc8thstudy.web.dto.StoreResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ApiResponse<ReviewResponseDTO.ReviewPreViewDTO> writeReview(@RequestBody ReviewRequestDTO.ReviewWrite request) {
        ReviewResponseDTO.ReviewPreViewDTO review = reviewService.writeReview(request);
        return ApiResponse.onSuccess(review);
    }

    @GetMapping("/{memberId}")
    public ApiResponse<Page<Review>> getMemberReviews(@PathVariable("memberId") Long memberId, @RequestParam(name = "page") Integer page) {
        Page<Review> response = reviewService.getMemberReview(memberId, page);
        return ApiResponse.onSuccess(response);
    }
}

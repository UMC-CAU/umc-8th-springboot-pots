package com.umcspring.umc8thstudy.web.controller;

import com.umcspring.umc8thstudy.apiPayload.ApiResponse;
import com.umcspring.umc8thstudy.domain.Review;
import com.umcspring.umc8thstudy.service.ReviewService.ReviewService;
import com.umcspring.umc8thstudy.web.dto.ReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ApiResponse<Review> writeReview(@RequestBody ReviewRequestDTO request) {
        Review review = reviewService.writeReview(request);
        return ApiResponse.onSuccess(review);
    }
}

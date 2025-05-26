package com.umcspring.umc8thstudy.repository;

import com.umcspring.umc8thstudy.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}

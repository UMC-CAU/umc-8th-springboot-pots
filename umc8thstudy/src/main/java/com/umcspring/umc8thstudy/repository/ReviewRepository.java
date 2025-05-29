package com.umcspring.umc8thstudy.repository;

import com.umcspring.umc8thstudy.domain.Review;
import com.umcspring.umc8thstudy.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);

}

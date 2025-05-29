package com.umcspring.umc8thstudy.service.StoreService;


import com.umcspring.umc8thstudy.domain.Review;
import com.umcspring.umc8thstudy.domain.Store;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
    Page<Review> getReviewList(Long StoreId, Integer page);


}

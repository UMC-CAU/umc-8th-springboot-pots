package com.umcspring.umc8thstudy.service.StoreService;


import com.umcspring.umc8thstudy.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
}

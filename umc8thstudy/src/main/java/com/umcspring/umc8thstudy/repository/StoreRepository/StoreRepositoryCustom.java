package com.umcspring.umc8thstudy.repository.StoreRepository;

import com.umcspring.umc8thstudy.domain.Store;
import java.util.List;


public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
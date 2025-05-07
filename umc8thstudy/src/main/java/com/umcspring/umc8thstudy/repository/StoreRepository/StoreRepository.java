package com.umcspring.umc8thstudy.repository.StoreRepository;

import com.umcspring.umc8thstudy.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}

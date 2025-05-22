package com.umcspring.umc8thstudy.repository;

import com.umcspring.umc8thstudy.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCategoryRepository extends JpaRepository<Food, Long> {
}

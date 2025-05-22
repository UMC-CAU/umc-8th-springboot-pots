package com.umcspring.umc8thstudy.converter;

import com.umcspring.umc8thstudy.domain.Food;
import com.umcspring.umc8thstudy.domain.mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<Food> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberPrefer.builder()
                                .food(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}


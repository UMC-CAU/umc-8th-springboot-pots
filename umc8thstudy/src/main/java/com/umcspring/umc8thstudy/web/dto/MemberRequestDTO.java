package com.umcspring.umc8thstudy.web.dto;

import com.umcspring.umc8thstudy.domain.enums.Gender;
import com.umcspring.umc8thstudy.domain.enums.MemberStatus;
import com.umcspring.umc8thstudy.domain.enums.SocialType;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        String name;
        String address;
        String phoneAddress;
        Date birth;

        //enum
        String gender;
        String socialType;
//        String status;

//        LocalDate inactiveDate;
//        Integer score;

        List<Long> memberPreferList;
        List<Long> memberAgreeList;
    }
}

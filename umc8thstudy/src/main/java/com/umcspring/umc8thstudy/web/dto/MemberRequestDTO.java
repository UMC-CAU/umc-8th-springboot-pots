package com.umcspring.umc8thstudy.web.dto;

import com.umcspring.umc8thstudy.domain.enums.Gender;
import com.umcspring.umc8thstudy.domain.enums.MemberStatus;
import com.umcspring.umc8thstudy.domain.enums.Role;
import com.umcspring.umc8thstudy.domain.enums.SocialType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    @Setter
    public static class JoinDto{
        String name;
        String address;
        @Email
        String email;
        String password;
        String phoneAddress;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        Date birth;

        //enum
        String gender;
        String socialType;
//        String status;

//        LocalDate inactiveDate;
//        Integer score;

        List<Long> memberPreferList;
        List<Long> memberAgreeList;
        Role role;
    }

    @Getter
    @Setter
    public static class LoginRequestDTO{
        @NotBlank(message = "이메일은 필수입니다.")
        @Email(message = "올바른 이메일 형식이어야 합니다.")
        private String email;

        @NotBlank(message = "패스워드는 필수입니다.")
        private String password;
    }
}

package com.umcspring.umc8thstudy.service.MemberService;

import com.umcspring.umc8thstudy.domain.Member;
import com.umcspring.umc8thstudy.web.dto.MemberRequestDTO;
import com.umcspring.umc8thstudy.web.dto.MemberResponseDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);

    MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request);

}

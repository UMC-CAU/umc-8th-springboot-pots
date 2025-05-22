package com.umcspring.umc8thstudy.service.MemberService;

import com.umcspring.umc8thstudy.domain.Member;
import com.umcspring.umc8thstudy.web.dto.MemberRequestDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);

}

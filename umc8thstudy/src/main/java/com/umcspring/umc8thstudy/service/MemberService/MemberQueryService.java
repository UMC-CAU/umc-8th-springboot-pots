package com.umcspring.umc8thstudy.service.MemberService;

import com.umcspring.umc8thstudy.web.dto.MemberResponseDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface MemberQueryService {
    MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request);
}

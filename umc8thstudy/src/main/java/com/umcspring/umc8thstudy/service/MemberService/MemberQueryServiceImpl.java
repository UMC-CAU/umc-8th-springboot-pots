package com.umcspring.umc8thstudy.service.MemberService;

import com.umcspring.umc8thstudy.apiPayload.code.status.ErrorStatus;
import com.umcspring.umc8thstudy.apiPayload.exception.handler.TempHandler;
import com.umcspring.umc8thstudy.config.security.jwt.JwtTokenProvider;
import com.umcspring.umc8thstudy.domain.Member;
import com.umcspring.umc8thstudy.converter.MemberConverter;
import com.umcspring.umc8thstudy.repository.MemberRepository;
import com.umcspring.umc8thstudy.web.dto.MemberResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional(readOnly = true)
    public MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request){
        Authentication authentication = jwtTokenProvider.extractAuthentication(request);
        String email = authentication.getName();

        Member member = memberRepository.findByEmail(email)
                .orElseThrow(()-> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return MemberConverter.toMemberInfoDTO(member);
    }
}

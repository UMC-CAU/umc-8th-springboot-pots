package com.umcspring.umc8thstudy.service.MemberService;

import com.umcspring.umc8thstudy.apiPayload.code.status.ErrorStatus;
import com.umcspring.umc8thstudy.apiPayload.exception.handler.TempHandler;
import com.umcspring.umc8thstudy.converter.MemberConverter;
import com.umcspring.umc8thstudy.converter.MemberPreferConverter;
import com.umcspring.umc8thstudy.domain.Food;
import com.umcspring.umc8thstudy.domain.Member;
import com.umcspring.umc8thstudy.domain.mapping.MemberPrefer;
import com.umcspring.umc8thstudy.repository.FoodCategoryRepository;
import com.umcspring.umc8thstudy.repository.MemberPreferRepository;
import com.umcspring.umc8thstudy.repository.MemberRepository;
import com.umcspring.umc8thstudy.web.dto.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final MemberPreferRepository memberPreferRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        Member newMember = MemberConverter.toMember(request);

        System.out.println("Member 생성 완료: " + newMember.getName());

        newMember.encodePassword(passwordEncoder.encode(request.getPassword()));

        List<Food> foodCategoryList = request.getMemberPreferList().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new TempHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        // Agree관련도 작성해야함

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);
        memberPreferList.forEach(prefer -> {
            prefer.setMember(newMember);                   // 연관관계 주인 쪽 설정
            newMember.getMemberPreferList().add(prefer);   // mappedBy 쪽도 동기화
        });
        Member savedMember = memberRepository.save(newMember);
        System.out.println("Member 저장 완료, ID: " + savedMember.getId());

        // MemberPrefer들도 명시적으로 저장
        memberPreferRepository.saveAll(memberPreferList);
        return savedMember;
    }



}

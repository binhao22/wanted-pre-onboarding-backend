package Wanted.Restful_API.service;


import Wanted.Restful_API.dto.MemberDTO;
import Wanted.Restful_API.entity.MemberEntity;
import Wanted.Restful_API.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    // Entity -> DB
    public void save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toSaveEntity(memberDTO, passwordEncoder);
        memberRepository.save(memberEntity);
    }

    public Optional<MemberEntity> findOne(String userId) {
        return memberRepository.findByUserid(userId);
    }
}

package Wanted.Restful_API.service;


import Wanted.Restful_API.dto.MemberDTO;
import Wanted.Restful_API.entity.MemberEntity;
import Wanted.Restful_API.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    // Entity -> DB
    public void save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toSaveEntity(memberDTO);
        memberRepository.save(memberEntity);
    }
}

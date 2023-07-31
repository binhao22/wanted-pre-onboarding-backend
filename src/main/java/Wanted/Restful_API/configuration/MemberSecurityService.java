package Wanted.Restful_API.configuration;

import Wanted.Restful_API.entity.MemberEntity;
import Wanted.Restful_API.service.MemberService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.lang.reflect.Member;
import java.util.Optional;

@Component
public class MemberSecurityService implements UserDetailsService {
    private final MemberService memberService;

    public MemberSecurityService(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public UserDetails loadUserByUsername(String insertedUserId) throws UsernameNotFoundException {
        Optional<MemberEntity> findOne = memberService.findOne(insertedUserId);
        MemberEntity memberEntity = findOne.orElseThrow(() -> new UsernameNotFoundException("존재하지않는 회원 정보입니다."));

        return User.builder()
                .username(memberEntity.getMemberEmail())
                .password(memberEntity.getMemberPassword())
                .roles(memberEntity.getMemberRoles())
                .build();
    }
}
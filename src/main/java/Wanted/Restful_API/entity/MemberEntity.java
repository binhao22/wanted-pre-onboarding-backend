package Wanted.Restful_API.entity;

import Wanted.Restful_API.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@Setter
@Table(name = "member_table")
public class MemberEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String memberEmail;

    @Column
    private String memberPassword;

    @Column
    private String memberRoles;

    // Dto -> Entity
    public static MemberEntity toSaveEntity(MemberDTO memberDTO, PasswordEncoder passwordEncoder) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPassword(passwordEncoder.encode(memberEntity.memberPassword));
        memberEntity.setMemberRoles("USER");
//        memberEntity.setMemberPassword(passwordEncoder.encode(memberDTO.getMemberPassword()));
        return memberEntity;
    }
}

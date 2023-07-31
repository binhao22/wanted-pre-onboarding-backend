package Wanted.Restful_API.dto;

import jakarta.validation.constraints.Pattern;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
// DTO 데이터 전송 객체 생성, 회원가입 입력 -> 회원가입 Dto
public class MemberDTO {
    private Long id;

    // @포함 모든 문자열
    @Pattern(regexp = ".*[@]+.*")
    private String memberEmail;
    // 8자 이상 모든 문자열
    @Pattern(regexp = ".{8,}")
    private String memberPassword;
}

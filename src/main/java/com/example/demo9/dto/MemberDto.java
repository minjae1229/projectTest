package com.example.demo9.dto;

import com.example.demo9.constant.Role;
import com.example.demo9.constant.UserDel;
import com.example.demo9.entity.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.swing.text.html.parser.Entity;
import java.util.Optional;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {

  private Long id;

  @NotEmpty(message = "이름은 필수 입력입니다.")
  @Length(min = 1, max = 20, message = "이름은 1~20자 이하로 입력해 주세요.")
  private String name;

  @NotEmpty(message = "이메일은 필수 입력입니다.")
  @Email(message = "이메일 형식으로 입력해 주세요.")
  private String email;

  @NotEmpty(message = "비밀번호는 필수 입력입니다.")
  @Length(min = 4, max = 20, message = "비밀번호는 4~20자 이하로 입력해 주세요.")
  private String password;

  private String address;

  private Role role;

  private UserDel userDel;

  public static MemberDto entityToDto(Optional<Member> optionalMember) {
    return MemberDto.builder()
            .id(optionalMember.get().getId())
            .name(optionalMember.get().getName())
            .email(optionalMember.get().getEmail())
            .password(optionalMember.get().getPassword())
            .address(optionalMember.get().getAddress())
            .role(optionalMember.get().getRole())
            .userDel(optionalMember.get().getUserDel())
            .build();

  }
}

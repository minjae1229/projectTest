package com.example.demo9.dto;

import com.example.demo9.entity.Guest;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuestDto {
  private Long id;
  private String name;
  private String content;
  private String email;
  private String homePage;
  private LocalDateTime visitDate;
  private String hostIp;

  public static GuestDto entityToDto(Optional<Guest> optionalGuest) {
    return GuestDto.builder()
            .id(optionalGuest.get().getId())
            .name(optionalGuest.get().getName())
            .content(optionalGuest.get().getContent())
            .email(optionalGuest.get().getEmail())
            .homePage(optionalGuest.get().getHomePage())
            .visitDate(optionalGuest.get().getVisitDate())
            .hostIp(optionalGuest.get().getHostIp())
            .build();
  }
}

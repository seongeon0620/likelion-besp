package com.likelion.myapp.entity;

// Dto 폴더 내부에는 디비와 관련 없는 것들

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {
    String access_token;
    String refresh_token;
}

package com.lion.myapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="TB_USER")
@Builder
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor // 생성자를 이용한 객체 생성자를 막자
@Getter
@Setter
public class UserDto {
    @Id
    long member_id;
    String userid;
    String username;
    String password;
    String email;
    String roles;
}

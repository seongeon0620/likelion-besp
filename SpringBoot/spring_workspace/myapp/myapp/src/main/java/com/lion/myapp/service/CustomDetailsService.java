package com.lion.myapp.service;

import com.example.demo.CustomUserDetails;
import com.lion.myapp.entity.UserDto;
import com.lion.myapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("userDetailsService")
public class CustomDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;  // 레포지토리 객체와 연결(DI)

    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // username => 디비에서 객체를 찾아오기 : repository를 통해 findById 객체를 가져옴
        // User -> username, passwor, roles 밖에 없음

        // username : 이 파라미터 하나만 받아 login.html => username 으로 user 값을 보냄
        // UserDetailsService의 loadUserByUsername 함수가 호출된다.
        // 이 앞단계는 스프링프레임워크에게 전달하고 우리가 loadUserByUsername를 호출해줄게

        // 디비에 가서 객체를 username으로 찾아 가져와서 => UserDetails
/*
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("1234")
                .roles("USER")
                .build();
                //        return user;
*/

        UserDto userDto = userRepository.findByUserName(username);
        // details에 암호화된 패스워드가 전달되어야 한다.
        // 회원가입시 encoding을 해서 저장하면 굳이 이작업이 필요하지않음
        userDto.setPassword(encoder.encode(userDto.getPassword()));

        CustomUserDetails details = new CustomUserDetails(userDto);
        return details;


    }
}

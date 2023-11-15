package com.lion.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// 버전이 바뀌면 변할 수 있으니 spring.io보고 만들 것
@Configuration
@EnableWebSecurity  // 웹보안을 사용하겠다
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 암호화 솔루션이 있는 경우 여기를 커스텀한다.
        return new BCryptPasswordEncoder();
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // authorizeHttpRequests 매개변수로 람다를 전달한다
        http
            .authorizeHttpRequests((requests) -> {
                // requests - 매개변수 이름은 내 마음대로. 보안을 요하지 않고 들어가도 되는 url 전달
                // 그러니까 /home은 로그인없이 들어갈 수 있는 것
                // permitAll() - 인증을 받지 않아도 접근 가능하다는 것
                // anyRequest 다른요청은 로그인이 필요하다.
                requests.requestMatchers("/", "/home")
                        .permitAll()
                        .anyRequest().authenticated();

            })
            .formLogin((login) -> {
                login.loginPage("/login").permitAll();  // 사용자가 지정한 페이지로.
                // username, password 라는 값을 전달하면 알아서 로그온 작업을 하고
                // 내부객체 SecurityContext에 저장한다.
                // 객체가 여기에 저장되어야 필처를 통과한다.
            })
            .logout((logout) -> {
                logout.logoutSuccessUrl("/").permitAll();
            }).csrf().disable();    // 보안으로 해당 코드 작성하지 않으면 로그인 되지 않음
        return http.build();
    }

    // 사용자 암호나 디비로부터 로그온을 하고 싶다. 별도의 클래스를 만들어야 한다.
/*    @Bean
    public UserDetailsService userDetailsService() {
        // UserDetailService -> 시스템이 제공. 우리가 상속받아 별도로 처리해야 함
        // UserDetails - 로그인시 사용하는 기본 Dto(username, password, roles)
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("1234")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }*/
}


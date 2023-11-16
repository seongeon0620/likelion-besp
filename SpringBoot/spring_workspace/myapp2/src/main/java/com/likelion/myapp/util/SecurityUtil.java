package com.likelion.myapp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class SecurityUtil {

   private static final Logger logger = LoggerFactory.getLogger(SecurityUtil.class);

   private SecurityUtil() {}

   // SecurityContext로부터 인증정보를 빼낸다
   // Optional<클래스명> 객체가 null인 경우
   public static Optional<String> getCurrentUsername() {
      // SecurityContextHolder.getContext().getAuthentication()
      // SecurityContext에서 인증정보를 가져온다
      final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

      if (authentication == null) {
         logger.debug("Security Context에 인증 정보가 없습니다.");
         return Optional.empty();   // null 값을 보낸다. 중간에 에러 발생시 리턴
      }

      // 찾아왔음 getPrincipal() username을 가져온다
      String username = null;
      if (authentication.getPrincipal() instanceof UserDetails) {
         UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
         username = springSecurityUser.getUsername();
      } else if (authentication.getPrincipal() instanceof String) {
         username = (String) authentication.getPrincipal();
      }

      // Optional 객체에 담아보내자
      // 토큰인증할건데 이게 왜 필요하죠 ?
      // 다른 필터들이 여기에 인증데티거아 없으면 통과 안시켜줌
      return Optional.ofNullable(username);
   }
}

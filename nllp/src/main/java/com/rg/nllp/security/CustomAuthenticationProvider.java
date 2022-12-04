package com.rg.nllp.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : com.rg.nllp.security
 * fileName       : CustomAuthenticationProvider
 * author         : hyeokchan
 * date           : 2022/11/27
 * description    : 스프링 시큐리티 로그인 처리
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/27        hyeokchan       최초 생성
 */
@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
    // 사용자정보 체크 서비스
    private final UserDetailsService userDetailsService;
    // 암복호화 처리 클래스
    private final BCryptPasswordEncoder passwordEncoder;

    /***
     * @description 인증 처리 로직
     * @param authentication 전달된 username(userId), password(userPw)에 대한 데이터 VO
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        CustomUserDetails customUserDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(username);
        // 넘겨받은 password와 암호화된 password 비교, 일치하지 않으면 예외처리
        if(!passwordEncoder.matches(password, customUserDetails.getPassword())){
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 로그인 성공시 USER 권한 부여
        authorities.add(new SimpleGrantedAuthority("USER"));
        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}

package com.rg.nllp.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * packageName    : com.rg.nllp
 * fileName       : SecurityConfig
 * author         : hyeokchan
 * date           : 2022/11/27
 * description    : 스프링 시큐리티 설정파일
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/27        hyeokchan       최초 생성
 */
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // 로그인 성공시 호출되는 핸들러
    private final AuthenticationSuccessHandler authenticationSuccessHandler;
    // 로그인 실패시 호출되는 핸들러
    private final AuthenticationFailureHandler authenticationFailureHandler;

    // 암호화 클래스 passwordEncoder
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 인증 및 인가에 대한 설정
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/user/login", "/user/register", "/css/**", "/js/**", "/assets/**", "/nllp/findNllpList", "/nllp/moveNllpInfoInst").permitAll() // 위 경로 호출들은 인증(로그인) 없이 허용
                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/user/login") // 로그인 페이지를 열때, /user/login GET 호출 -> UserController에서 loginForm.html 호출
                .loginProcessingUrl("/user/login")  // loginForm.html에서 로그인 버튼 클릭 시 /user/login POST 호출
                .usernameParameter("userId")    // spring security 처리 시 username를 변수로 사용하는데 인자로 userId 사용
                .passwordParameter("userPw")    // spring security 처리 시 password를 변수로 사용하는데 인자로 userPw 사용
                .successHandler(authenticationSuccessHandler)   // 인증 성공시 호출되는 핸들러
                .failureHandler(authenticationFailureHandler)   // 인증 실패시 호출되는 핸들러
                .and()
                .logout()   // 로그아웃 설정
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))    // /user/logout이 호출되었을 때 로그아웃 처리, bodyHeader.html에서 호출
                .logoutSuccessUrl("/user/login")    // 로그아웃 성공시 호출하는 경로, UserController에 의해 loginForm.html로 이동
                .invalidateHttpSession(true);
    }
}
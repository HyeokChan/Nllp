package com.rg.nllp;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * packageName    : com.rg.nllp
 * fileName       : SecurityConfig
 * author         : hyeokchan
 * date           : 2022/11/27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/27        hyeokchan       최초 생성
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * PasswordEncoder를 Bean으로 등록
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 인증 or 인가에 대한 설정
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/").permitAll()
            .anyRequest().authenticated();*/
        http.csrf().disable();
    }
}
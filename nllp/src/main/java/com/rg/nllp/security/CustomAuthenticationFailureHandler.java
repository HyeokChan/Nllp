package com.rg.nllp.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * packageName    : com.rg.nllp.security
 * fileName       : CustomAuthenticationFailureHandler
 * author         : hyeokchan
 * date           : 2022/11/27
 * description    : 로그인 실패 시 호출되는 핸들러
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/27        hyeokchan       최초 생성
 */
@Component
@Slf4j
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    /***
     * @description 로그인 실패 시 로그인 화면으로 리다이렉트
     * @param request
     * @param response
     * @param exception
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        String error = "";
        if(exception instanceof UsernameNotFoundException){
            error = "username";
        }
        else if(exception instanceof BadCredentialsException){
            error = "password";
        }
        // 에러 처리
        response.sendRedirect("/user/login?error="+error+"&exception="+ URLEncoder.encode(exception.getMessage(),"UTF-8"));
    }
}

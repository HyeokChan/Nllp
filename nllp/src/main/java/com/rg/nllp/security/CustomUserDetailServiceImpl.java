package com.rg.nllp.security;

import com.rg.nllp.common.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.rg.nllp.security
 * fileName       : CustomUserDetailService
 * author         : hyeokchan
 * date           : 2022/11/28
 * description    : 로그인 로직처리
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/28        hyeokchan       최초 생성
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailServiceImpl implements UserDetailsService {
    private final UserMapper userMapper;

    /***
     * @description 인증 처리 로직 커스텀 서비스
     * 사용자계정으로 비밀번호 조회
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = this.userMapper.findUserDetails(username);
        if(userDetails == null){
            throw new UsernameNotFoundException("존재하지 않는 사용자 계정입니다.");
        }
        return userDetails;
    }
}

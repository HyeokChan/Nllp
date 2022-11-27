package com.rg.nllp.common.service.impl;

import com.rg.nllp.common.mapper.UserMapper;
import com.rg.nllp.common.service.UserService;
import com.rg.nllp.common.vo.user.RegisterVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.rg.nllp.common.controller
 * fileName       : UserServiceImpl
 * author         : hyeokchan
 * date           : 2022/10/26
 * description    : 사용자정보 로직
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/26        hyeokchan       최초 생성
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    // 회원가입 처리
    @Override
    public int instUserInfo(RegisterVO inVO) throws Exception {
        inVO.setUserPw(passwordEncoder.encode(inVO.getUserPw()));
        int rst = this.userMapper.instUserInfo(inVO);
        return rst;
    }

}

package com.rg.nllp.common.service.impl;

import com.rg.nllp.common.mapper.UserMapper;
import com.rg.nllp.common.service.UserService;
import com.rg.nllp.common.vo.UserDVO;
import com.rg.nllp.common.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    UserMapper userMapper;
    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDVO findUserInfo(UserVO inVO) throws Exception {
        UserDVO userDVO = userMapper.findUserInfo(inVO);
        log.info("userDVO 출력 ::::: {}", userDVO);
        return userDVO;
    }
}

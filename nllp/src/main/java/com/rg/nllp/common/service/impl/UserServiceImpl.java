package com.rg.nllp.common.service.impl;

import com.rg.nllp.common.mapper.UserMapper;
import com.rg.nllp.common.service.UserService;
import com.rg.nllp.common.vo.UserDVO;
import com.rg.nllp.common.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name = "userMapper")
    UserMapper userMapper;
    @Override
    public UserDVO findUserInfo(UserVO inVO) throws Exception {
        UserDVO userDVO = new UserDVO();
        return userMapper.findUserInfo(inVO);
        //return userDVO;
    }
}

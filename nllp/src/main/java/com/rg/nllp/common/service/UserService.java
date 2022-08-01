package com.rg.nllp.common.service;

import com.rg.nllp.common.vo.UserDVO;
import com.rg.nllp.common.vo.UserVO;
import org.springframework.stereotype.Service;

public interface UserService {
    UserDVO findUserInfo(UserVO inVO) throws Exception;

}

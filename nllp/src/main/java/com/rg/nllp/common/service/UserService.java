package com.rg.nllp.common.service;

import com.rg.nllp.common.vo.user.UserRVO;
import com.rg.nllp.common.vo.user.UserVO;

public interface UserService {
    /*로그인 처리*/
    UserRVO findUserInfo(UserVO inVO) throws Exception;
    /*사용자신청 처리*/
    UserRVO instUserReqInfo(UserVO inVO) throws Exception;
    /*사용자신청허가(관리자)*/
    UserRVO instUserInfo(UserVO inVO) throws Exception;
}

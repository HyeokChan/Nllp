package com.rg.nllp.common.mapper;

import com.rg.nllp.common.vo.user.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /*사용자 체크*/
    int checkUserInfo(UserVO inVO) throws Exception;
    /*기 신청된 사용자 아이디 체크*/
    int checkDupUserReqInfo(UserVO inVO) throws Exception;
    /*사용자신청 처리*/
    int instUserReqInfo(UserVO inVO) throws Exception;
    /*사용자신청 허가처리*/
    int instUserInfo(UserVO inVO) throws Exception;
    /*사용자신청 반영처리*/
    int updtUserReqInfo(UserVO inVO) throws Exception;
}

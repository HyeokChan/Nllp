package com.rg.nllp.common.mapper;

import com.rg.nllp.common.vo.user.UserVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * packageName    : com.rg.nllp.common.controller
 * fileName       : UserMapper
 * author         : hyeokchan
 * date           : 2022/10/26
 * description    : 사용자정보 mapper 인터페이스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/26        hyeokchan       최초 생성
 */
@Mapper
public interface UserMapper {
    /*사용자 체크*/
    int findUserInfo(UserVO inVO) throws Exception;
    /*기 신청된 사용자 아이디 체크*/
    int checkDupUserReqInfo(UserVO inVO) throws Exception;
    /*사용자신청 처리*/
    int instUserReqInfo(UserVO inVO) throws Exception;
    /*사용자신청 허가처리*/
    int instUserInfo(UserVO inVO) throws Exception;
    /*사용자신청 반영처리*/
    int updtUserReqInfo(UserVO inVO) throws Exception;
}

package com.rg.nllp.common.mapper;

import com.rg.nllp.common.vo.user.LoginVO;
import com.rg.nllp.common.vo.user.RegisterVO;
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
    // 사용자 체크
    String findUserInfo(LoginVO inVO) throws Exception;
    // 회원가입 처리
    int instUserInfo(RegisterVO inVO) throws Exception;
}

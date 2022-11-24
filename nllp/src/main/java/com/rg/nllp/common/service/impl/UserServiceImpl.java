package com.rg.nllp.common.service.impl;

import com.rg.nllp.common.mapper.UserMapper;
import com.rg.nllp.common.service.UserService;
import com.rg.nllp.common.vo.user.UserRVO;
import com.rg.nllp.common.vo.user.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    /*로그인 처리*/
    @Override
    public UserRVO findUserInfo(UserVO inVO) throws Exception {
        UserRVO rvo = new UserRVO();
        int rst = this.userMapper.checkUserInfo(inVO);
        if(rst < 1){
            throw new Exception("등록된 사용자가 아닙니다.");
        }
        return rvo;
    }
    /*사용자신청 처리*/
    @Override
    public UserRVO instUserReqInfo(UserVO inVO) throws Exception {
        UserRVO rvo = new UserRVO();
        log.info("inVO ::::: {}", inVO);
        /*기 신청된 아이디 체크*/
        int chkRst = this.userMapper.checkDupUserReqInfo(inVO);
        if(chkRst > 0){
            throw new Exception("이미 신청된 아이디입니다.");
        }
        int rst = this.userMapper.instUserReqInfo(inVO);
        return rvo;
    }
    /*사용자신청허가(관리자)*/
    @Override
    public UserRVO instUserInfo(UserVO inVO) throws Exception {
        UserRVO rvo = new UserRVO();
        int instRst = this.userMapper.instUserInfo(inVO);
        if(instRst > 0){
            /*신청테이블 반영처리*/
            this.userMapper.updtUserReqInfo(inVO);
        }
        return rvo;
    }
}

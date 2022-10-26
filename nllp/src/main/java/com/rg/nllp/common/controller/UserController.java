package com.rg.nllp.common.controller;

import com.rg.nllp.common.service.UserService;
import com.rg.nllp.common.vo.user.UserDVO;
import com.rg.nllp.common.vo.user.UserRVO;
import com.rg.nllp.common.vo.user.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * packageName    : com.rg.nllp.common.controller
 * fileName       : UserController
 * author         : hyeokchan
 * date           : 2022/10/26
 * description    : 사용자정보 controller
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/26        hyeokchan       최초 생성
 */
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    /*로그인 처리*/
    @PostMapping(value = "/findUserInfo")
    public @ResponseBody UserRVO findUserInfo(@RequestBody UserVO inVO) throws Exception {
        UserRVO rvo = this.userService.findUserInfo(inVO);
        return rvo;
    }
    /*사용자 신청 처리*/
    @PostMapping(value = "/instUserReqInfo")
    public @ResponseBody UserRVO instUserReq(@RequestBody UserVO inVO) throws Exception {
        UserRVO rvo = this.userService.instUserReqInfo(inVO);
        return rvo;
    }
    /*사용자신청허가(관리자)*/
    @PostMapping(value = "/instUserInfo")
    public @ResponseBody UserRVO instUserInfo(@RequestBody UserVO inVO) throws Exception {
        UserRVO rvo = this.userService.instUserInfo(inVO);
        return rvo;
    }
}

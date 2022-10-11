package com.rg.nllp.common.controller;

import com.rg.nllp.common.service.UserService;
import com.rg.nllp.common.vo.UserDVO;
import com.rg.nllp.common.vo.UserRVO;
import com.rg.nllp.common.vo.UserVO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    /*로그인 처리*/
    @PostMapping(value = "/signin")
    public @ResponseBody UserRVO signin(UserVO inVO) throws Exception {
        UserRVO userRVO = new UserRVO();
        UserDVO userDVO = new UserDVO();
        userDVO = userService.findUserInfo(inVO);
        log.info("controller dvo ::::: {}", userDVO);
        userRVO.setRData(userDVO);
        return userRVO;
    }
}

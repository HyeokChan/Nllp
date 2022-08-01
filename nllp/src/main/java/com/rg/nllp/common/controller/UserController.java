package com.rg.nllp.common.controller;

import com.rg.nllp.common.service.UserService;
import com.rg.nllp.common.vo.UserDVO;
import com.rg.nllp.common.vo.UserRVO;
import com.rg.nllp.common.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource(name = "userService")
    UserService userService;

    @PostMapping(value = "/signin")
    @ResponseBody
    public UserRVO signin(UserVO inVO) throws Exception {
        UserRVO userRVO = new UserRVO();
        UserDVO userDVO = new UserDVO();
        userDVO = userService.findUserInfo(inVO);



        userRVO.setStatus(200);
        return userRVO;
    }
}

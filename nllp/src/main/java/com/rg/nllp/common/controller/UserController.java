package com.rg.nllp.common.controller;

import com.rg.nllp.common.service.UserService;
import com.rg.nllp.common.vo.user.UserRVO;
import com.rg.nllp.common.vo.user.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    /***
     * @discription 로그인화면 이동
     * @return 로그인화면
     */
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("userInfo", new UserVO());
        return "common/user/loginForm";
    }

    /***
     * @discription 로그인처리
     * @param inVO
     * @param result 검증 및 에러처리
     * @return 로그인 성공시 메인화면, 실패시 로그인화면
     * @throws Exception
     */
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("userInfo") UserVO inVO, BindingResult result) throws Exception{
        if(result.hasErrors()){
            return "common/user/loginForm";
        }
        int rst = this.userService.findUserInfo(inVO);
        if(rst == 0){
            result.addError(new FieldError("userInfo", "userPw", "사용자정보가 없습니다."));
        }
        return "common/user/loginForm";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("userInfo", new UserVO());
        return "common/user/registerForm";
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

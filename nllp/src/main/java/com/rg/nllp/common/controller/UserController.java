package com.rg.nllp.common.controller;

import com.rg.nllp.common.service.UserService;
import com.rg.nllp.common.vo.user.RegisterVO;
import com.rg.nllp.common.vo.user.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
     * @description 로그인화면 이동
     * @param error 로그인 실패시 실패 원인 구분
     * @param exception 실패 메시지
     * @return 로그인화면
     */
    @GetMapping("/login")
    public String login(Model model, @RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "exception", required = false) String exception){
        model.addAttribute("userInfo", new UserVO())
                .addAttribute("error", error)
                .addAttribute("exception", exception);
        return "common/user/loginForm";
    }

    /***
     * @description 로그인처리 -> security
     * @loginProcessingUrl /user/login
     * @success response.sendRedirect("/main");
     * @fail response.sendRedirect("/user/login?error="+error+"&exception="+ URLEncoder.encode(exception.getMessage(),"UTF-8"));
     */

    /***
     * @description 로그아웃처리 -> security
     * @logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
     * @logoutSuccessUrl("/user/login")
     */


    /**
     * @description 회원가입화면 이동
     * @param model
     * @return 회원가입화면
     */
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("userInfo", new UserVO());
        return "common/user/registerForm";
    }

    /***
     * @description 회원가입처리
     * @param inVO
     * @param result 에러처리
     * @return 로그인화면
     * @throws Exception
     */
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("userInfo") RegisterVO inVO, BindingResult result) throws Exception{
        if(!inVO.getUserPw().equals(inVO.getUserPwCf())){
            result.addError(new FieldError("userInfo", "userPwCf", "비밀번호와 다릅니다."));
        }
        if(result.hasErrors()){
            return "common/user/registerForm";
        }
        int rst = this.userService.instUserInfo(inVO);
        if(rst == 0){
            result.addError(new FieldError("userInfo", "userId", "이미 등록된 아이디가 존재합니다."));
            return "common/user/registerForm";
        }
        return "redirect:/user/login";
    }

}

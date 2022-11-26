package com.rg.nllp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * packageName    : com.rg.nllp
 * fileName       : HomeController
 * author         : hyeokchan
 * date           : 2022/11/22
 * description    : 메인 컨트롤러
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/22        hyeokchan       최초 생성
 */
@Controller
@Slf4j
public class MainController {
    /***
     * @discription 로그인화면 이동
     * @param
     * @return 로그인화면
     */
    @GetMapping("/")
    public String home() {
        return "redirect:/user/login";
    }

    @GetMapping("/main")
    public String main(){
        return "main";
    }
}

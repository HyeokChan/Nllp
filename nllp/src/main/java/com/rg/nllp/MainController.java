package com.rg.nllp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    //홈 화면으로 자동 이동
    @GetMapping("/")
    public String home() {
        return "home";
    }
}

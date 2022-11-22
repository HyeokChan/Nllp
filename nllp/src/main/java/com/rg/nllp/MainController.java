package com.rg.nllp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * packageName    : com.rg.nllp
 * fileName       : HomeController
 * author         : hyeokchan
 * date           : 2022/11/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/22        hyeokchan       최초 생성
 */
@Controller
@Slf4j
public class MainController {
    @GetMapping("main")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!!");
        return "index";
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/nllpListForm")
    public String nllpListForm() {
        return "nllpListForm";
    }

}

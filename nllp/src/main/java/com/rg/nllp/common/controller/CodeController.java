package com.rg.nllp.common.controller;

import com.rg.nllp.common.vo.code.CodeVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * packageName    : com.rg.nllp.common.controller
 * fileName       : CodeController
 * author         : hyeokchan
 * date           : 2022/12/07
 * description    : 코드관리처리 컨트롤러
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/12/07        hyeokchan       최초 생성
 */
@Controller
@RequestMapping("/code")
@RequiredArgsConstructor
@Slf4j
public class CodeController {

    /***
     * @description 코드목록화면으로 이동
     * @param model
     * @return
     */
    @GetMapping("/moveCodeList")
    public String moveCodeList(Model model){
        CodeVO inVO = new CodeVO();
        model.addAttribute("codeSearchInfo", inVO);
        return "common/code/codeListForm";
    }

    @GetMapping("/moveCodeInfoInst")
    public String moveCodeInfoInst(Model model){
        CodeVO inVO = new CodeVO();
        model.addAttribute("codeInfo", inVO);
        return "common/code/codeInfoInstForm";
    }
}

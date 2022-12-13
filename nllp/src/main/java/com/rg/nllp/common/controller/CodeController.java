package com.rg.nllp.common.controller;

import com.rg.nllp.common.service.CodeService;
import com.rg.nllp.common.vo.code.CodeDVO;
import com.rg.nllp.common.vo.code.CodeVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

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

    private final CodeService codeService;

    /***
     * @description 코드목록화면으로 이동
     * @param model
     * @return
     */
    @GetMapping("/moveCodeList")
    public String moveCodeList(Model model) throws Exception{
        CodeVO inVO = new CodeVO();
        inVO.setCodes(this.codeService.findCodes(Arrays.asList("com0002")));
        model.addAttribute("codeSearchInfo", inVO);
        return "common/code/codeListForm";
    }

    /***
     * @description 코드등록화면으로 이동
     * @param model
     * @return
     */
    @GetMapping("/moveCodeInfoInst")
    public String moveCodeInfoInst(Model model) throws Exception{
        CodeVO inVO = new CodeVO();
        inVO.setCodes(this.codeService.findCodes(Arrays.asList("com0001", "com0002")));
        model.addAttribute("codeInfoInstForm", inVO);
        return "common/code/codeInfoInstForm";
    }

    /**
     * @description 신규코드 저장처리
     * @param inVO
     * @return
     * @throws Exception
     */
    @PostMapping("/instCodeInfo")
    public String instCodeInfo(@Valid @ModelAttribute("codeInfoInstForm") CodeVO inVO, Model model) throws Exception {
        int rst = this.codeService.instCodeInfo(inVO);
        inVO.setCodes(this.codeService.findCodes(Arrays.asList("com0002")));
        model.addAttribute("codeSearchInfo", inVO);
        return "common/code/codeListForm";
    }

    /***
     * @description 코드정보 목록조회 datatables
     * @param inVO
     * @return
     * @throws Exception
     */
    @PostMapping("/findCodeList")
    public @ResponseBody List<CodeDVO> findCodeList(@ModelAttribute("json") CodeVO inVO) throws Exception {
        List<CodeDVO> rList = this.codeService.findCodeList(inVO);
        return rList;
    }

}

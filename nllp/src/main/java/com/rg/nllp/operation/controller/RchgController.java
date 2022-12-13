package com.rg.nllp.operation.controller;

import com.rg.nllp.common.service.CodeService;
import com.rg.nllp.operation.service.RchgService;
import com.rg.nllp.operation.vo.NllpVO;
import com.rg.nllp.operation.vo.RchgVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * packageName    : com.rg.nllp.operation.controller
 * fileName       : RchgController
 * author         : hyeokchan
 * date           : 2022/10/31
 * description    : 계약자료관리 컨트롤러
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/31        hyeokchan       최초 생성
 */
@Controller
@RequestMapping("/rchg")
@RequiredArgsConstructor
@Slf4j
public class RchgController {
    private final RchgService rchgService;
    private final CodeService codeService;
    /***
     * @description 계약자료 목록조회
     * @param model
     * @return 계약자료 조회화면으로 이동, 조회조건 VO 전달
     * @throws Exception
     */
    @GetMapping("/moveRchgList")
    public String findRchgList(Model model) throws Exception {
        RchgVO inVO = new RchgVO();
        inVO.setCodes(this.codeService.findCodes(Arrays.asList("com0003", "biz0005")));
        model.addAttribute("rchgSearchInfo", inVO);
        return "operation/rchg/rchgListForm";
    }
}

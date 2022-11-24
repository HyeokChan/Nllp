package com.rg.nllp.operation.controller;

import com.rg.nllp.operation.service.NllpService;
import com.rg.nllp.operation.vo.NllpDVO;
import com.rg.nllp.operation.vo.NllpRVO;
import com.rg.nllp.operation.vo.NllpVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName    : com.rg.nllp.operation.controller
 * fileName       : NllpController
 * author         : hyeokchan
 * date           : 2022/10/26
 * description    : 기초자료관리 controller
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/26        hyeokchan       최초 생성
 */
@Controller
@RequestMapping("nllp")
@RequiredArgsConstructor
@Slf4j
public class NllpController {
    private final NllpService nllpService;
    // 재산 목록 조회, 조회 화면으로 이동
    @GetMapping("/nllpList")
    public String findNllpList(Model model) throws Exception {
        NllpVO inVO = new NllpVO();
        List<NllpDVO> rList = this.nllpService.findNllpList(inVO);
        model.addAttribute("nllpList", rList);
        return "operation/nllpListForm";
    }
    @GetMapping("/nllpInfo/{itemId}")
    public String findNllpInfo(@PathVariable("itemId") String nllpAcbKey, Model model) throws Exception{
        NllpVO inVO = new NllpVO();
        inVO.setNllpAcbKey(nllpAcbKey);
        NllpDVO rData = this.nllpService.findNllpInfo(inVO);
        model.addAttribute("nllpInfo", rData);
        return "operation/nllpInfoUpdtForm";
    }
    @PostMapping("/updtNllpInfo")
    public String updtNllpInfo(@ModelAttribute("nllpInfo") NllpVO inVO) throws Exception{
        this.nllpService.updtNllpInfo(inVO);
        return "redirect:/nllp/nllpList";
    }
    @GetMapping("/nllpInstForm")
    public String nllpInstForm(Model model) throws Exception {
        return "nllpInstForm";
    }





    /*기초자료 등록*/
    @PostMapping(value = "/instNllpInfo")
    public @ResponseBody NllpRVO instNllpInfo(@RequestBody NllpVO inVO) throws Exception {
        NllpRVO rvo = this.nllpService.instNllpInfo(inVO);
        return rvo;
    }

    /*기초자료 삭제*/
    @PostMapping(value = "/deltNllpInfo")
    public @ResponseBody NllpRVO deltNllpInfo(@RequestBody NllpVO inVO) throws Exception {
        NllpRVO rvo = this.nllpService.deltNllpInfo(inVO);
        return rvo;
    }




}

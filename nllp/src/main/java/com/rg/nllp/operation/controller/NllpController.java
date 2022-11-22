package com.rg.nllp.operation.controller;

import com.rg.nllp.operation.service.NllpService;
import com.rg.nllp.operation.vo.NllpRVO;
import com.rg.nllp.operation.vo.NllpVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    /*기초자료 목록조회*/
    @PostMapping(value = "/findNllpList")
    public @ResponseBody NllpRVO findNllpList(@RequestBody NllpVO inVO) throws Exception {
        NllpRVO rvo = this.nllpService.findNllpList(inVO);
        return rvo;
    }

    @GetMapping("/nllpList")
    public String findNllpList(Model model) throws Exception {
        NllpVO inVO = new NllpVO();
        inVO.setSgbCd("3550000");
        inVO.setNllpAcbSeCd("01");
        NllpRVO rvo = this.nllpService.findNllpList(inVO);
        model.addAttribute("nllpList", rvo.getRList());
        return "nllpListForm";
    }
    @GetMapping("/dtl/{itemId}")
    public String findNllpInfo(@PathVariable("itemId") String nllpAcbKey, Model model) throws Exception{
        NllpVO inVO = new NllpVO();
        inVO.setSgbCd("3550000");
        inVO.setNllpAcbSeCd("01");
        inVO.setNllpAcbKey(nllpAcbKey);
        NllpRVO rvo = this.nllpService.findNllpInfo(inVO);
        model.addAttribute("nllpInfo", rvo.getRData());
        return "nllpInfoForm";
    }
    @PostMapping("/dtl/{itemId}")
    public String updateItem(@PathVariable String itemId, @ModelAttribute("nllpInfo") NllpVO inVO) throws Exception{
        log.info("inVO Con : {}", inVO);
        inVO.setSgbCd("3550000");
        NllpRVO rvo = this.nllpService.updtNllpInfo(inVO);
        return "redirect:/nllp/nllpList";
    }


    /*기초자료 상세조회*/
    @PostMapping(value = "/findNllpInfo")
    public @ResponseBody NllpRVO findNllpInfo(@RequestBody NllpVO inVO) throws Exception {
        NllpRVO rvo = this.nllpService.findNllpInfo(inVO);
        return rvo;
    }

    /*기초자료 등록*/
    @PostMapping(value = "/instNllpInfo")
    public @ResponseBody NllpRVO instNllpInfo(@RequestBody NllpVO inVO) throws Exception {
        NllpRVO rvo = this.nllpService.instNllpInfo(inVO);
        return rvo;
    }

    /*기초자료 수정*/
    @PostMapping(value = "/updtNllpInfo")
    public @ResponseBody NllpRVO updtNllpInfo(@RequestBody NllpVO inVO) throws Exception {
        NllpRVO rvo = this.nllpService.updtNllpInfo(inVO);
        return rvo;
    }

    /*기초자료 삭제*/
    @PostMapping(value = "/deltNllpInfo")
    public @ResponseBody NllpRVO deltNllpInfo(@RequestBody NllpVO inVO) throws Exception {
        NllpRVO rvo = this.nllpService.deltNllpInfo(inVO);
        return rvo;
    }




}

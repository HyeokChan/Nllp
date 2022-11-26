package com.rg.nllp.operation.controller;

import com.rg.nllp.operation.service.NllpService;
import com.rg.nllp.operation.vo.NllpDVO;
import com.rg.nllp.operation.vo.NllpVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

    /***
     * @description 재산자료 목록조회
     * @param model
     * @return 조회된 재산자료 목록, 재산자료 조회화면으로 이동
     * @throws Exception
     */
    @GetMapping("/findNllpList")
    public String findNllpList(Model model) throws Exception {
        NllpVO inVO = new NllpVO();
        List<NllpDVO> rList = this.nllpService.findNllpList(inVO);
        model.addAttribute("nllpList", rList);
        return "operation/nllp/nllpListForm";
    }

    /***
     * @description 재산자료 상세조회
     * @param nllpAcbKey
     * @param model
     * @return 조회된 재산자료, 재산자료 상세화면으로 이동
     * @throws Exception
     */
    @GetMapping("/findNllpInfo/{itemId}")
    public String findNllpInfo(@PathVariable("itemId") String nllpAcbKey, Model model) throws Exception{
        NllpVO inVO = new NllpVO();
        inVO.setNllpAcbKey(nllpAcbKey);
        NllpDVO rData = this.nllpService.findNllpInfo(inVO);
        model.addAttribute("nllpInfo", rData);
        return "operation/nllp/nllpInfoUpdtForm";
    }

    /***
     * @description 재산자료 수정처리
     * @param inVO
     * @return 재산자료 재조회
     * @throws Exception
     */
    @PostMapping("/updtNllpInfo")
    public String updtNllpInfo(@ModelAttribute("nllpInfo") NllpVO inVO) throws Exception{
        int rst = this.nllpService.updtNllpInfo(inVO);
        return "redirect:/nllp/findNllpList";
    }

    /**
     * @description 재산자료 삭제처리
     * @param inVO
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/deltNllpInfo")
    public String deltNllpInfo(@ModelAttribute("nllpInfo") NllpVO inVO) throws Exception {
        int rst = this.nllpService.deltNllpInfo(inVO);
        return "redirect:/nllp/findNllpList";
    }

    /***
     * @description 재산자료 등록화면 이동
     * @return 재산자료 등록화면
     * @throws Exception
     */
    @GetMapping("/instNllpInfo")
    public String instNllpInfo(Model model) throws Exception {
        model.addAttribute("nllpInfo", new NllpVO());
        return "operation/nllp/nllpInfoInstForm";
    }

    /***
     * @description 재산자료 등록처리
     * @param inVO
     * @return
     * @throws Exception
     */
    @PostMapping("instNllpInfo")
    public String instNllpInfo(@ModelAttribute("nllpInfo") NllpVO inVO) throws Exception{
        String nllpAcbKey = this.nllpService.instNllpInfo(inVO);
        return "redirect:/nllp/findNllpInfo/" + nllpAcbKey;
    }

}

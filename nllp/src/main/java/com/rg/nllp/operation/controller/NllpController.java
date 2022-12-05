package com.rg.nllp.operation.controller;

import com.rg.nllp.operation.service.NllpService;
import com.rg.nllp.operation.vo.NllpDVO;
import com.rg.nllp.operation.vo.NllpInstVO;
import com.rg.nllp.operation.vo.NllpVO;
import com.rg.nllp.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
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
@RequestMapping("/nllp")
@RequiredArgsConstructor
@Slf4j
public class NllpController {

    private final NllpService nllpService;

    /***
     * @description 재산자료 목록조회
     * @param model
     * @return 재산자료 조회화면으로 이동, 조회조건 VO 전달
     * @throws Exception
     */
    @GetMapping("/findNllpList")
    public String findNllpList(Model model) throws Exception {
        NllpVO inVO = new NllpVO();
        model.addAttribute("nllpSearchInfo", inVO);
        return "operation/nllp/nllpListForm";
    }

    /***
     * @description 재산자료 목록조회 datatables
     * @param inVO
     * @return
     * @throws Exception
     */
    @PostMapping("/findNllpList")
    public @ResponseBody List<NllpDVO> findNllpList(@ModelAttribute("json") NllpVO inVO) throws Exception {
        List<NllpDVO> rList = this.nllpService.findNllpList(inVO);
        return rList;
    }

    /***
     * @description 재산자료 신규등록 화면으로 이동
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/moveNllpInfoInst")
    public String moveNllpInfoInst(Model model) throws Exception {
        NllpInstVO inVO = new NllpInstVO();
        model.addAttribute("nllpInfo", inVO);
//        return "operation/nllp/nllpInfoInstForm";
        return "redirect:/nllp/findNllpInfo/" + "20220000014";
    }

    /***
     * @description 재산자료 등록처리
     * @param inVO
     * @return
     * @throws Exception
     */
    @PostMapping("instNllpInfo")
    public String instNllpInfo(@Valid @ModelAttribute("nllpInfo") NllpInstVO inVO, BindingResult result) throws Exception{
        if(result.hasErrors()){
            return "operation/nllp/nllpInfoInstForm";
        }
        String nllpAcbKey = this.nllpService.instNllpInfo(inVO);
        return "redirect:/nllp/findNllpInfo/" + nllpAcbKey;
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
    public String updtNllpInfo(@ModelAttribute("nllpInfo") NllpVO inVO, @AuthenticationPrincipal String username) throws Exception{

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



}

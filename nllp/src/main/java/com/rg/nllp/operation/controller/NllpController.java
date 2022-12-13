package com.rg.nllp.operation.controller;

import com.rg.nllp.common.service.CodeService;
import com.rg.nllp.common.vo.code.CodeDVO;
import com.rg.nllp.common.vo.code.CodeVO;
import com.rg.nllp.operation.service.NllpService;
import com.rg.nllp.operation.vo.NllpDVO;
import com.rg.nllp.operation.vo.NllpInstVO;
import com.rg.nllp.operation.vo.NllpUpdtVO;
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
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
    private final CodeService codeService;

    /***
     * @description 재산자료 목록조회
     * @param model
     * @return 재산자료 조회화면으로 이동, 조회조건 VO 전달
     * @throws Exception
     */
    @GetMapping("/moveNllpList")
    public String findNllpList(Model model) throws Exception {
        NllpVO inVO = new NllpVO();
        inVO.setCodes(this.codeService.findCodes(Arrays.asList("biz0001")));
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
        inVO.setCodes(this.codeService.findCodes(Arrays.asList("biz0001", "biz0002", "biz0003")));
        model.addAttribute("nllpInfo", inVO);
        return "operation/nllp/nllpInfoInstForm";
    }

    /***
     * @description 재산자료 등록처리
     * @param inVO
     * @return
     * @throws Exception
     */
    @PostMapping("instNllpInfo")
    public String instNllpInfo(@Valid @ModelAttribute("nllpInfo") NllpInstVO inVO, BindingResult result, Model model) throws Exception{
        if(result.hasErrors()){
            inVO.setCodes(this.codeService.findCodes(Arrays.asList("biz0001", "biz0002", "biz0003")));
            model.addAttribute("nllpInfo", inVO);
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
        rData.setCodes(this.codeService.findCodes(Arrays.asList("biz0001", "biz0002", "biz0003")));
        model.addAttribute("nllpInfo", rData);
        return "operation/nllp/nllpInfoUpdtForm";
    }

    /***
     * @description 재산자료 수정처리
     * @param inVO
     * @return 재산자료 재조회
     * @throws Exception
     */
    @PostMapping("/updtNllpInfo/{itemId}")
    public String updtNllpInfo(@PathVariable("itemId") String nllpAcbKey, @Valid @ModelAttribute("nllpInfo") NllpUpdtVO inVO, BindingResult result, Model model) throws Exception{
        if (result.hasErrors()) {
            inVO.setCodes(this.codeService.findCodes(Arrays.asList("biz0001", "biz0002", "biz0003")));
            model.addAttribute("nllpInfo", inVO);
            return "operation/nllp/nllpInfoUpdtForm";
        }
        inVO.setNllpAcbKey(nllpAcbKey);
        int rst = this.nllpService.updtNllpInfo(inVO);
        return "redirect:/nllp/findNllpInfo/" + nllpAcbKey;
    }

    /**
     * @description 재산자료 삭제처리
     * @param nllpAcbKey
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/deltNllpInfo/{itemId}")
    public String deltNllpInfo(@PathVariable("itemId") String nllpAcbKey) throws Exception {
        NllpVO inVO = new NllpVO();
        inVO.setNllpAcbKey(nllpAcbKey);
        int rst = this.nllpService.deltNllpInfo(inVO);
        return "redirect:/nllp/moveNllpList";
    }

}

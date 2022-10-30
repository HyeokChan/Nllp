package com.rg.nllp.operation.controller;

import com.rg.nllp.operation.service.NllpService;
import com.rg.nllp.operation.vo.NllpRVO;
import com.rg.nllp.operation.vo.NllpVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /*기초자료 목록조회*/
    @PostMapping(value = "/findNllpList")
    public @ResponseBody NllpRVO findNllpList(@RequestBody NllpVO inVO) throws Exception {
        NllpRVO rvo = this.nllpService.findNllpList(inVO);
        return rvo;
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

}

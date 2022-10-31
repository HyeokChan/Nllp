package com.rg.nllp.operation.controller;

import com.rg.nllp.operation.service.RchgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

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
@RequiredArgsConstructor
@Slf4j
public class RchgController {
    private final RchgService rchgService;
}

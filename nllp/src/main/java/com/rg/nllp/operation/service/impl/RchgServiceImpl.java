package com.rg.nllp.operation.service.impl;

import com.rg.nllp.operation.mapper.RchgMapper;
import com.rg.nllp.operation.service.RchgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.rg.nllp.operation.service.impl
 * fileName       : RchgServiceImpl
 * author         : hyeokchan
 * date           : 2022/10/31
 * description    : 계약자료관리 로직
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/31        hyeokchan       최초 생성
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class RchgServiceImpl implements RchgService {
    private final RchgMapper rchgMapper;

}

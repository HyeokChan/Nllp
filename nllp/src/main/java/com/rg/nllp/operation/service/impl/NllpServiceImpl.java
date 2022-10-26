package com.rg.nllp.operation.service.impl;

import com.rg.nllp.operation.mapper.NllpMapper;
import com.rg.nllp.operation.service.NllpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.rg.nllp.operation.service.impl
 * fileName       : NllpServiceImpl
 * author         : hyeokchan
 * date           : 2022/10/26
 * description    : 기초자료관리 로직
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/26        hyeokchan       최초 생성
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class NllpServiceImpl implements NllpService {
    private final NllpMapper nllpMapper;
}

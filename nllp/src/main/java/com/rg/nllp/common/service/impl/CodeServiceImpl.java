package com.rg.nllp.common.service.impl;

import com.rg.nllp.common.mapper.CodeMapper;
import com.rg.nllp.common.service.CodeService;
import com.rg.nllp.common.vo.code.CodeDVO;
import com.rg.nllp.common.vo.code.CodeVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName    : com.rg.nllp.common.service.impl
 * fileName       : CodeServiceImpl
 * author         : hyeokchan
 * date           : 2022/12/07
 * description    : 코드처리 로직 클래스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/12/07        hyeokchan       최초 생성
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CodeServiceImpl implements CodeService {
    private final CodeMapper codeMapper;

    // 화면별 코드정보 조회
    @Override
    public List<CodeDVO> findDtlCodeList(CodeVO inVO) throws Exception {
        log.info("inVO:::::{}", inVO);
        return this.codeMapper.findDtlCodeList(inVO);
    }
    // 코드정보 신규저장
    @Override
    public int instCodeInfo(CodeVO inVO) throws Exception {
        // 코드정보 저장
        int rst = this.codeMapper.instCodeInfo(inVO);
        if(rst > 0){
            int dtlRst = this.codeMapper.instDtlCodeList(inVO);
        }
        // 상세코드정보 저장
        return 0;
    }
    // 코드정보 목록 조회
    @Override
    public List<CodeDVO> findCodeList(CodeVO inVO) throws Exception {
        List<CodeDVO> rList = this.codeMapper.findCodeList(inVO);
        return rList;
    }
}

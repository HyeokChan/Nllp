package com.rg.nllp.common.service;

import com.rg.nllp.common.vo.code.CodeDVO;
import com.rg.nllp.common.vo.code.CodeVO;

import java.util.List;

/**
 * packageName    : com.rg.nllp.common.service
 * fileName       : CodeService
 * author         : hyeokchan
 * date           : 2022/12/07
 * description    : 코드처리 인터페이스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/12/07        hyeokchan       최초 생성
 */
public interface CodeService {
    List<CodeDVO> findDtlCodeList(CodeVO inVO) throws Exception;
    int instCodeInfo(CodeVO inVO) throws Exception;
    List<CodeDVO> findCodeList(CodeVO inVO) throws Exception;
}

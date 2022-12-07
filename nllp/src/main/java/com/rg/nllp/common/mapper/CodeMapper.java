package com.rg.nllp.common.mapper;

import com.rg.nllp.common.vo.code.CodeDVO;
import com.rg.nllp.common.vo.code.CodeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName    : com.rg.nllp.common.mapper
 * fileName       : CodeMapper
 * author         : hyeokchan
 * date           : 2022/12/07
 * description    : 코드처리 mybatis 인터페이스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/12/07        hyeokchan       최초 생성
 */
@Mapper
public interface CodeMapper {
    List<CodeDVO> findDtlCodeList(CodeVO inVO) throws Exception;
    int instCodeInfo(CodeVO inVO) throws Exception;
    int instDtlCodeList(CodeVO inVO) throws Exception;
    List<CodeDVO> findCodeList(CodeVO inVO) throws Exception;
}

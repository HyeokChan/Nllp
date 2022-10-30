package com.rg.nllp.operation.mapper;

import com.rg.nllp.operation.vo.NllpDVO;
import com.rg.nllp.operation.vo.NllpVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName    : com.rg.nllp.operation.mapper
 * fileName       : NllpMapper
 * author         : hyeokchan
 * date           : 2022/10/26
 * description    : 기초자료관리 mapper 인터페이스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/26        hyeokchan       최초 생성
 */
@Mapper
public interface NllpMapper {
    /*기초자료토지 목록조회*/
    List<NllpDVO> findNllpLandList(NllpVO inVO) throws Exception;
    /*기초자료건물 목록조회*/
    List<NllpDVO> findNllpBldgList(NllpVO inVO) throws Exception;
    /*기초자료토지 상세조회*/
    NllpDVO findNllpLandInfo(NllpVO inVO) throws Exception;
    /*기초자료건물 상세조회*/
    NllpDVO findNllpBldgInfo(NllpVO inVO) throws Exception;
    /*기초자료 등록*/
    int instNllpInfo(NllpVO inVO) throws Exception;
}

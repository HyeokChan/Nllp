package com.rg.nllp.operation.service;

import com.rg.nllp.operation.vo.NllpRVO;
import com.rg.nllp.operation.vo.NllpVO;

/**
 * packageName    : com.rg.nllp.operation.service
 * fileName       : NllpService
 * author         : hyeokchan
 * date           : 2022/10/26
 * description    : 기초자료관리 로직 인터페이스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/26        hyeokchan       최초 생성
 */
public interface NllpService {
    /*기초자료 목록조회*/
    NllpRVO findNllpList(NllpVO inVO) throws Exception;

    NllpRVO findNllpInfo(NllpVO inVO) throws Exception;
}

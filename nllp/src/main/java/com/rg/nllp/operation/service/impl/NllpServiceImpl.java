package com.rg.nllp.operation.service.impl;

import com.rg.nllp.operation.mapper.NllpMapper;
import com.rg.nllp.operation.service.NllpService;
import com.rg.nllp.operation.vo.NllpDVO;
import com.rg.nllp.operation.vo.NllpRVO;
import com.rg.nllp.operation.vo.NllpVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    // 기초자료 목록조회
    @Override
    public List<NllpDVO> findNllpList(NllpVO inVO) throws Exception {
        List<NllpDVO> rList = this.nllpMapper.findNllpList(inVO);
        if(rList.isEmpty()){
            throw new Exception("조회된 자료가 없습니다.");
        }
        return rList;
    }

    // 기초자료 상세조회
    @Override
    public NllpDVO findNllpInfo(NllpVO inVO) throws Exception {
        NllpDVO rData = this.nllpMapper.findNllpInfo(inVO);
        if (rData == null) {
            throw new Exception("자료 조회에 실패했습니다.");
        }
        return rData;
    }

    // 기초자료 수정
    @Override
    public int updtNllpInfo(NllpVO inVO) throws Exception {
        int rst = this.nllpMapper.updtNllpInfo(inVO);
        if (rst == 0) {
            throw new Exception("자료 수정에 실패했습니다.");
        }
        return rst;
    }

    /*기초자료 등록*/
    @Override
    public NllpRVO instNllpInfo(NllpVO inVO) throws Exception {
        NllpRVO rvo = new NllpRVO();
        int rst = this.nllpMapper.instNllpInfo(inVO);
        if (rst == 0) {
            throw new Exception("자료 등록에 실패했습니다.");
        }
        return rvo;
    }

    /*기초자료 삭제*/
    @Override
    public NllpRVO deltNllpInfo(NllpVO inVO) throws Exception {
        NllpRVO rvo = new NllpRVO();
        int rst = this.nllpMapper.deltNllpInfo(inVO);
        if (rst == 0) {
            throw new Exception("자료 삭재에 실패했습니다.");
        }
        return rvo;
    }
}

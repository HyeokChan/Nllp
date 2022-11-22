package com.rg.nllp.operation.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * packageName    : com.rg.nllp.operation.vo
 * fileName       : RchgRVO
 * author         : hyeokchan
 * date           : 2022/10/31
 * description    : 계약자료관리 return VO
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/31        hyeokchan       최초 생성
 */
@Getter
@Setter
public class NllpRVO {
    private NllpDVO rData;
    private List<NllpDVO> rList;
}

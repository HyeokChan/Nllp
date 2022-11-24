package com.rg.nllp.operation.vo;

import com.rg.nllp.DefaultVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

/**
 * packageName    : com.rg.nllp.operation.vo
 * fileName       : NllpDVO
 * author         : hyeokchan
 * date           : 2022/10/26
 * description    : 기초자료관리 data VO
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/26        hyeokchan       최초 생성
 */
@Getter
@Setter
@ToString
@Alias("nllpDVO")
public class NllpDVO extends DefaultVO {
    private String sgbCd;
    private String nllpAcbKey;
    private String nllpAcbNo;
    private String nllpAcbSeCd;
    private String lgoCd;
    private String lvyTrgtNm;
    private String landAr;
    private String bldgAr;
    private String oalp;
    private String oalpYr;
    private String stdAmt;
    private String stdYr;
    private String lotnoRoadAddrSeCd;
    private String zip;
    private String stdgCd;
    private String lotnoBacAddr;
    private String lotnoDaddr;
    private String mtnSeCd;
    private String mno;
    private String sno;
    private String roadNmCd;
    private String roadNmBacAddr;
    private String roadNmDaddr;
    private String udgdYn;
    private String bmno;
    private String bsno;
    private String spclDg;
    private String spclHo;
    private String ldcgCd;
    private String bldgStrcCd;
    private String roofShpeCd;
    private String rmCn;

    private String totCnt;
    private String lotnoAlAddr;
    private String roadNmAlAddr;
    private String lastUpdtDate;
}

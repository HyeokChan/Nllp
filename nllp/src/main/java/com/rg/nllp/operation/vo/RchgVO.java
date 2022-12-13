package com.rg.nllp.operation.vo;

import com.rg.nllp.DefaultVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

/**
 * packageName    : com.rg.nllp.operation.vo
 * fileName       : RchgVO
 * author         : hyeokchan
 * date           : 2022/10/31
 * description    : 계약자료관리 inVO
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/31        hyeokchan       최초 생성
 */
@Getter
@Setter
@ToString
@Alias("rchgVO")
public class RchgVO extends DefaultVO {
    private String rchgAcbKey;
    private String rchgAcbNo;
    private String pyrMngNo;
    private String pyrAddrSeCd;
    private String pyrAddrSn;
    private String ctrtMtdCd;
    private String ctrtYmd;
    private String prmsnBgngYmd;
    private String prmsnEndYmd;
    private String ntntaxRt;
    private String ctpvRt;
    private String sggRt;
    private String rmCn;
    private String delYn;

    private String rchgNllpSn;
    private String glMngNo;
    private String nllpAcbKey;
    private String ocpatAr;
    private String vatSeCd;

    private String pyrSeCd;
    private String pyrSttCd;
    private String pyrNm;
    private String pyrNo;
    private String pyrBrthYmd;

    private String pyrZip;
    private String pyrStdgCd;
    private String pyrLotnoBacAddr;
    private String pyrLotnoDaddr;
    private String pyrMtnSeCd;
    private String pyrMno;
    private String pyrSno;
    private String pyrSpclDg;
    private String pyrSpclHo;

    private String glNm;
    private String glSeCd;
    private String glZip;
    private String glStdgCd;
    private String glLotnoBacAddr;
    private String glLotnoDaddr;
    private String glMtnSeCd;
    private String glMno;
    private String glSno;
    private String glSpclDg;
    private String glSpclHo;

    private String rchgAcbNoFrom;
    private String rchgAcbNoTo;
}

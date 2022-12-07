package com.rg.nllp.operation.vo;

import com.rg.nllp.DefaultVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.NotBlank;

/**
 * packageName    : com.rg.nllp.operation.vo
 * fileName       : NllpVO
 * author         : hyeokchan
 * date           : 2022/10/26
 * description    : 기초자료관리 inVO
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/26        hyeokchan       최초 생성
 */
@Getter
@Setter
@ToString
@Alias("nllpVO")
public class NllpVO extends DefaultVO {
    private String nllpAcbKey;
    private String nllpAcbNo;
    private String lgoCd;
    private String nllpNm;
    private String landAr;
    private String oalp;
    private String oalpYr;
    private String zip;
    private String stdgCd;
    private String lotnoBacAddr;
    private String lotnoDaddr;
    private String mtnSeCd;
    private String mno;
    private String sno;
    private String spclDg;
    private String spclHo;
    private String ldcgCd;
    private String rmCn;
    private String nllpAcbNoFrom;
    private String nllpAcbNoTo;
}

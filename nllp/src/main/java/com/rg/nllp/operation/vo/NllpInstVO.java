package com.rg.nllp.operation.vo;

import com.rg.nllp.DefaultVO;
import com.rg.nllp.common.vo.code.CodeDVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * packageName    : com.rg.nllp.operation.vo
 * fileName       : NllpInstVO
 * author         : hyeokchan
 * date           : 2022/12/05
 * description    : 재산자료 신규등록 처리를 위한 VO
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/12/05        hyeokchan       최초 생성
 */
@Getter
@Setter
@ToString
@Alias("nllpInstVO")
public class NllpInstVO extends DefaultVO {
    private String nllpAcbKey;
    @NotBlank(message = "기본주소를 입력해주세요")
    @Size(max = 300, message = "기본주소 길이를 확인해주세요(300)")
    private String lotnoBacAddr;
    @Size(max = 300, message = "상세주소 길이를 확인해주세요(300)")
    private String lotnoDaddr;
    @NotBlank(message = "산을 입력해주세요")
    @Size(max = 2, message = "산 길이를 확인해주세요(2)")
    private String mtnSeCd;
    @NotBlank(message = "본번 입력해주세요")
    @Size(max = 4, message = "본번 길이를 확인해주세요(4)")
    private String mno;
    @Size(max = 4, message = "부번 길이를 확인해주세요(4)")
    private String sno;
    @NotBlank(message = "면적을 입력해주세요")
    @Digits(integer = 19, fraction = 9, message = "면적 길이를 확인해주세요(19,9)")
    private String landAr;
    @Size(max = 4, message = "공시지가연도 길이를 확인해주세요(4)")
    private String oalpYr;
    @NotBlank(message = "공시지가를 입력해주세요")
    @Size(max = 15, message = "공시지가 길이를 확인해주세요(15)")
    private String oalp;
    @NotBlank(message = "소관청 입력해주세요")
    @Size(max = 3, message = "소관청 길이를 확인해주세요(3)")
    private String lgoCd;
    @NotBlank(message = "지목을 입력해주세요")
    @Size(max = 2, message = "지목 길이를 확인해주세요(2)")
    private String ldcgCd;
    @Size(max = 4000, message = "재산명 길이를 확인해주세요(4000)")
    private String nllpNm;
    @Size(max = 4000, message = "비고 길이를 확인해주세요(4000)")
    private String rmCn;
    private String zip;
    private String nllpAcbNo;
    private String stdgCd;
    private String spclDg;
    private String spclHo;
}

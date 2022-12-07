package com.rg.nllp.common.vo.code;

import com.rg.nllp.DefaultVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

/**
 * packageName    : com.rg.nllp.common.vo.code
 * fileName       : CmCdVO
 * author         : hyeokchan
 * date           : 2022/12/07
 * description    : 공통코드관리 VO
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/12/07        hyeokchan       최초 생성
 */
@Getter
@Setter
@ToString
@Alias("codeDVO")
public class CodeDVO extends DefaultVO {
    private String cdId;
    private String cdNm;
    private String useYn;
    private String dtlCdId;
    private String dtlCdNm;
    private String cdSeCd;
    private String useYnNm;
}

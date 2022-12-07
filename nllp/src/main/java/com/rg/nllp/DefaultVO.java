package com.rg.nllp;

import com.rg.nllp.common.vo.code.CodeDVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.util.List;

/**
 * packageName    : com.rg.nllp.common.vo.user
 * fileName       : UserVO
 * author         : hyeokchan
 * date           : 2022/10/24
 * description    : 시스템항목을 갖는 Default VO
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/24        hyeokchan       최초 생성
 */
@Setter
@Getter
@ToString
public class DefaultVO {
    private String initUserId;
    private String initDate;
    private String updtUserId;
    private String updtDate;
    private List<CodeDVO> codes;
}

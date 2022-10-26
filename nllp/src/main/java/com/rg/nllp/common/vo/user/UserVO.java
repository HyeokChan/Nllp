package com.rg.nllp.common.vo.user;

import com.rg.nllp.DefaultVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName    : com.rg.nllp.common.vo.user
 * fileName       : UserVO
 * author         : hyeokchan
 * date           : 2022/10/24
 * description    : 사용자정보 inVO
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/24        hyeokchan       최초 생성
 */
@Getter
@Setter
@ToString
public class UserVO extends DefaultVO {
    private String sgbCd;
    private String userId;
    private String userPw;
    private String userNm;
}

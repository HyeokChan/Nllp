package com.rg.nllp.common.vo.user;

import com.rg.nllp.DefaultVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

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
@Alias("userVO")
public class UserVO extends DefaultVO {
    @NotBlank(message = "아이디를 입력해주세요")
    private String userId;
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String userPw;
    private String userNm;
    private String notFoundUser;
}

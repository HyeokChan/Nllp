package com.rg.nllp.common.vo.user;

import com.rg.nllp.DefaultVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.NotBlank;

/**
 * packageName    : com.rg.nllp.common.vo.user
 * fileName       : RegisterVO
 * author         : hyeokchan
 * date           : 2022/11/27
 * description    : 회원가입처리를 위한 VO
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/27        hyeokchan       최초 생성
 */
@Getter
@Setter
@ToString
@Alias("registerVO")
public class RegisterVO extends DefaultVO {
    @NotBlank(message = "아이디를 입력해주세요")
    private String userId;
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String userPw;
    @NotBlank(message = "사용자명을 입력해주세요")
    private String userNm;
    private String userPwCf;
}

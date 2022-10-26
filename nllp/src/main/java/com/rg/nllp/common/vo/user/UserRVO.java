package com.rg.nllp.common.vo.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * packageName    : com.rg.nllp.common.vo.user
 * fileName       : UserRVO
 * author         : hyeokchan
 * date           : 2022/10/24
 * description    : 사용자정보 return VO
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/24        hyeokchan       최초 생성
 */
@Getter
@Setter
@ToString
public class UserRVO {
    private UserDVO rData;
    private List<UserDVO> rList;
}

package com.rg.nllp.common.vo;

import com.rg.nllp.DefaultVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserVO extends DefaultVO {
    private String userId;
    private String userPassword;
}

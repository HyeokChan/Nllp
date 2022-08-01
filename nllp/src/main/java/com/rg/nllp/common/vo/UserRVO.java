package com.rg.nllp.common.vo;

import com.rg.nllp.DefaultVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class UserRVO extends DefaultVO {
    private List<UserDVO> rList;
    private UserDVO rData;
}

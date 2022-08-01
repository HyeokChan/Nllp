package com.rg.nllp.common.mapper;

import com.rg.nllp.common.vo.UserDVO;
import com.rg.nllp.common.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserDVO findUserInfo(UserVO inVO) throws Exception;
}

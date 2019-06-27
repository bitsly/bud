package org.bitsly.bud.user.dao;

import org.bitsly.bud.user.model.UserPassword;

public interface UserPasswordMapper {
    int insertSelective(UserPassword record);

    UserPassword selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserPassword record);
}
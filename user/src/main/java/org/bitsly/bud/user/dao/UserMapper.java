package org.bitsly.bud.user.dao;

import org.bitsly.bud.user.model.User;

public interface UserMapper {
    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);
}
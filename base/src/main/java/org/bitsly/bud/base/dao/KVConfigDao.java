package org.bitsly.bud.base.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.bitsly.bud.base.pojo.entity.KVConfigEntity;

@Mapper
public interface KVConfigDao {
    KVConfigEntity selectOneByPrimaryKey(@Param("key") String key);
}

package org.bitsly.bud.testtool;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by liuhuan on 2019/2/19.
 */
@Mapper
@Repository
public interface MySQLMapper {

    @Select("select 1")
    String select();
}

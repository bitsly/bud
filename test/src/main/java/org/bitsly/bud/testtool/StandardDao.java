package org.bitsly.bud.testtool;

import java.util.List;

/**
 * Created by liuhuan on 22/03/2019.
 */
public interface StandardDao<T> {

    Integer insertOneSelective(T record);

    Integer insertListSelective(List<T> records);
}

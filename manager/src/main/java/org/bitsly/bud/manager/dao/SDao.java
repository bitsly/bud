package org.bitsly.bud.manager.dao;

/**
 * Created by liuhuan on 22/03/2019.
 */
public interface SDao<T> {
    Integer select(T record);
}

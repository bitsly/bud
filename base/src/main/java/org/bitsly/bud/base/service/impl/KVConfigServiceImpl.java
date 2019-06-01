package org.bitsly.bud.base.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.bitsly.bud.base.dao.KVConfigDao;
import org.bitsly.bud.base.pojo.entity.KVConfigEntity;
import org.bitsly.bud.base.service.KVConfigService;

import javax.annotation.Resource;

@Service(protocol="dubbo")
public class KVConfigServiceImpl implements KVConfigService {

    @Resource
    private KVConfigDao kvConfigDao;

    @Override
    public KVConfigEntity show(String key) {
        return kvConfigDao.selectOneByPrimaryKey(key);
    }
}

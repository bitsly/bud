package org.bitsly.bud.base.service;

import org.bitsly.bud.base.pojo.entity.KVConfigEntity;

public interface KVConfigService {
    KVConfigEntity show(String key);
}

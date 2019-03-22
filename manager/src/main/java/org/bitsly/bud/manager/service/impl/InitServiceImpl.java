package org.bitsly.bud.manager.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.bitsly.bud.manager.dao.ConfigDao;
import org.springframework.stereotype.Service;

/**
 * Created by liuhuan on 22/03/2019.
 */
@Slf4j
@Service
public class InitServiceImpl {
    @Resource
    private ConfigDao configDao;

    @PostConstruct
    public void init() {
        log.warn(configDao.select(2222) + " -------------");
    }
}

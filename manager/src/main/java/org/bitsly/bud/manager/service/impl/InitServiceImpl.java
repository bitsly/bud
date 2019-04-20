package org.bitsly.bud.manager.service.impl;


import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by liuhuan on 22/03/2019.
 */
@Slf4j
@Service
public class InitServiceImpl {
    @NacosValue("${aa}")
    private String ab;

    @Scheduled(fixedDelay = 5_000)
    public void init() {
        log.warn(" -------------" + ab);
    }
}

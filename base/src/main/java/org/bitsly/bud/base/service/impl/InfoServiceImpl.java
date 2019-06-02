package org.bitsly.bud.base.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.bitsly.bud.base.service.InfoService;

import java.util.HashMap;
import java.util.Map;

@Service
public class InfoServiceImpl implements InfoService {
    @Override
    public Object getInfo() {
        Map<String, String> result = new HashMap<>();
        result.put("state", "healthy");
        return result;
    }
}

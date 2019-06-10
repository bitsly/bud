package org.bitsly.bud.manager.controller;

import org.bitsly.bud.manager.manager.DubboInvokeManager;
import org.springframework.web.bind.annotation.*;

@RestController
public class DubboInvokeController {

    /**
     * POST http://127.0.0.1:8090/call/org.bitsly.bud.base.service.InfoService/getInfo
     * @param interfaceName
     * @param method
     * @param version
     * @param parameterTypes
     * @param args
     * @return
     */
    @RequestMapping(value="/call/{interfaceName}/{method}",method= RequestMethod.POST)
    public Object call(@PathVariable String interfaceName,
                       @PathVariable String method,
                       @RequestParam(required = false) String version,
                       @RequestParam(required = false) String[] parameterTypes,
                       @RequestParam(required = false) Object[] args) {
        return DubboInvokeManager.invoke(interfaceName, version, method, parameterTypes, args);
    }
}

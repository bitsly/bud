package org.bitsly.bud.manager.manager;

/**
 * 泛化调用dubbo服务端
 */
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.apache.dubbo.rpc.service.GenericService;

public class DubboInvokeManager {

    public static Object invoke(String interfaceName, String version, String method, String[] parameterTypes, Object[] args) {
        // 创建服务实例
        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        reference.setGeneric(true);
        reference.setInterface(interfaceName);
        reference.setVersion(version);

        // 获取缓存中的实例
        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
        GenericService genericService = cache.get(reference);

        // 调用实例
        return genericService.$invoke(method, parameterTypes, args);
    }
}

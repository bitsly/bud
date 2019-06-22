package org.bitsly.bud.common.util;

import org.bitsly.bud.common.config.ContextConfig;
import org.springframework.context.ApplicationContext;

public class ContextUtil {

    public static ApplicationContext getContext() {
        return ContextConfig.APPLICATION_CONTEXT;
    }
}

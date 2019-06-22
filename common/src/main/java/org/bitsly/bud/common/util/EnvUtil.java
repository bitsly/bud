package org.bitsly.bud.common.util;

import org.bitsly.bud.common.config.ContextConfig;
import org.springframework.core.env.Environment;

public class EnvUtil {

    public static Environment getContext() {
        return ContextConfig.ENVIRONMENT;
    }
}

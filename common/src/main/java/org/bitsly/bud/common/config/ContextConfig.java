package org.bitsly.bud.common.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

/**
 * 把IoC容器中的值赋到静态变量中，方便直接使用
 */
@Configuration
public class ContextConfig {
    public static ApplicationContext APPLICATION_CONTEXT;
    public static Environment ENVIRONMENT;

    @Resource
    public void setApplicationContext(ApplicationContext applicationContext) {
        APPLICATION_CONTEXT = applicationContext;
    }

    @Resource
    public void setEnvironment(Environment environment) {
        ENVIRONMENT = environment;
    }

}

package org.bitsly.bud.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * 注册Web配置
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //区域语言拦截器
        registry.addInterceptor(localeChangeInterceptor())
                .addPathPatterns("/**");
    }

    /**
     * 可以将?locale=zh_CN写入到cookie中，并忽略错误
     * 配置文件里面指定 spring.mvc.locale=zh_CN 配置默认
     */
    private LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setIgnoreInvalidLocale(true);
        localeChangeInterceptor.setParamName("LANG");
        return localeChangeInterceptor;
    }

    /**
     * 使用cookie中的配置确定语言，如果cookie没有语言，则使用header中的Accept-Language
     * 配合WebAppConfig中的LocaleChangeInterceptor
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setCookieName("LANG");
        return localeResolver;
    }

    /**
     * Spring Boot的MVC默认配置中使用的 ViewResolver 为 ContentNegotiatingViewResolver。
     * 该视图解析器的功能是根据要请求的文档类型，来查找不同的视图以返回对应格式的文档。
     * 请求的文档类型要可以从请求头中的Accept中获取，也可以通过URI后缀名得到，如/login.html即为请求HTML格式的文档。
     * 这两种方式分别对应着两种不同的Strategy(策略)，默认为根据URI后缀名。
     *
     * 其实它的初衷是好的，它是想实现访问/user.json时返回JSON数据，访问/user.html返回HTML, 访问/user.xml则返回XML的功能。
     * 但是在这里我们只用Spring Boot提供RESTful接口，因此该功能就无用武之地了。
     * http://412887952-qq-com.iteye.com/blog/2315133
     * @param configurer
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        //favorPathExtension表示支持后缀匹配
        configurer.favorPathExtension(false);
    }

    /**
     * http://www.spring4all.com/article/177
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //添加映射路径
        registry.addMapping("/**")
                //是否发送Cookie信息
                .allowCredentials(true)
                //放行哪些原始域
                .allowedOrigins("*")
                //放行哪些原始域(头部信息)
                .allowedHeaders("*")
                //放行哪些原始域(请求方式)
                .allowedMethods("*");

    }

}

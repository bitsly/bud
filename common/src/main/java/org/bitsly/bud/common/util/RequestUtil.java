package org.bitsly.bud.common.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 请求工具类
 */
public class RequestUtil {

    /**
     * 获取request
     */
    public static ServletRequestAttributes getRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    }


    /**
     * 获取客户端ip
     * nginx 中需要配置
     * proxy_set_header Host $host;
     * proxy_set_header X-Real-IP $remote_addr;
     * proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
     */
    public static String getClientIp() {
        String ip = getRequestAttributes().getRequest().getHeader("X-Forwarded-For");
        if (StringUtils.isNotBlank(ip) && StringUtils.equalsIgnoreCase(ip, "unknown")) {
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = getRequestAttributes().getRequest().getHeader("X-Real-IP");
        if (StringUtils.isNotBlank(ip) && StringUtils.equalsIgnoreCase(ip, "unknown")) {
            return ip;
        }
        return getRequestAttributes().getRequest().getRemoteAddr();
    }
}

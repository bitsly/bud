package org.bitsly.bud.user.model;

import lombok.Data;

@Data
public class UserPassword {
    /**
    * 物理主键，自增
    */
    private Long id;

    /**
    * 创建时间，毫秒级
    */
    private Long created;

    /**
    * 更新时间，毫秒级
    */
    private Long updated;

    /**
    * 版本号
    */
    private Long version;

    /**
    * 用户唯一标识，内部流转
    */
    private Long userId;

    /**
    * 散列后的密码
    */
    private String password;

    /**
    * 用户盐
    */
    private String salt;

    /**
    * 两步验证秘钥
    */
    private String totpKey;

    /**
    * 用户自我验证信息
    */
    private String fWelcome;
}
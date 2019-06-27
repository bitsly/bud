package org.bitsly.bud.user.model;

import lombok.Data;

@Data
public class User {
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
    * 类型：0普通账户，1子账户
    */
    private Byte type;

    /**
    * 类型是子账户的情况下母账户id
    */
    private Long parentId;

    /**
    * 用户唯一标识，外部显示
    */
    private String uid;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 邮箱是否经过验证：0未验证，1已验证
    */
    private Byte isEmailVerified;

    /**
    * 国际电话区号
    */
    private String countryCallingCodes;

    /**
    * 邮箱
    */
    private String phone;

    /**
    * 电话是否经过验证：0未验证，1已验证
    */
    private Byte isPhoneVerified;

    /**
    * 状态: 0已经注销，1正常登陆，2禁止登陆
    */
    private Byte state;

    /**
    * 两步验证策略
    */
    private Long fTwoStep;
}
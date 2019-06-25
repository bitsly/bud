CREATE TABLE IF NOT EXISTS t_user (
	f_id BIGINT UNSIGNED NOT NULL  AUTO_INCREMENT COMMENT '物理主键，自增',
	f_created BIGINT UNSIGNED NOT NULL COMMENT '创建时间，毫秒级',
	f_updated BIGINT UNSIGNED NOT NULL COMMENT '更新时间，毫秒级',
	f_version BIGINT UNSIGNED NOT NULL COMMENT '版本号',
	f_user_id BIGINT UNSIGNED NOT NULL COMMENT '用户唯一标识，内部流转',
	f_type TINYINT UNSIGNED NOT NULL COMMENT '类型：0普通账户，1子账户',
	f_parent_id BIGINT UNSIGNED NOT NULL COMMENT '类型是子账户的情况下母账户id',
	f_uid VARCHAR(30) NOT NULL COMMENT '用户唯一标识，外部显示',
	f_email VARCHAR(284) NOT NULL COMMENT '邮箱',
	f_is_email_verified TINYINT UNSIGNED NOT NULL COMMENT '邮箱是否经过验证：0未验证，1已验证',
	f_country_calling_codes VARCHAR(9) NOT NULL COMMENT '国际电话区号',
	f_phone VARCHAR(18) NOT NULL COMMENT '邮箱',
	f_is_phone_verified TINYINT UNSIGNED NOT NULL COMMENT '电话是否经过验证：0未验证，1已验证',
	f_state TINYINT UNSIGNED NOT NULL COMMENT '状态: 0已经注销，1正常登陆，2禁止登陆',
	f_two_step BIGINT UNSIGNED NOT NULL COMMENT '两步验证策略',
	PRIMARY KEY (f_id),
	UNIQUE KEY unq_user_id (f_user_id),
	UNIQUE KEY unq_uid (f_uid),
	UNIQUE KEY unq_email (f_email),
	UNIQUE KEY unq_code_phone (f_country_calling_codes, f_phone)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '用户表';


CREATE TABLE IF NOT EXISTS t_user_password (
	f_id BIGINT UNSIGNED NOT NULL  AUTO_INCREMENT COMMENT '物理主键，自增',
	f_created BIGINT UNSIGNED NOT NULL COMMENT '创建时间，毫秒级',
	f_updated BIGINT UNSIGNED NOT NULL COMMENT '更新时间，毫秒级',
	f_version BIGINT UNSIGNED NOT NULL COMMENT '版本号',
	f_user_id BIGINT UNSIGNED NOT NULL COMMENT '用户唯一标识，内部流转',
	f_password VARCHAR(256) NOT NULL COMMENT '散列后的密码',
	f_salt CHAR(128) NOT NULL COMMENT '用户盐',
	f_totp_key VARCHAR(256) NOT NULL COMMENT '两步验证秘钥',
	f_welcome VARCHAR(32) NOT NULL COMMENT '用户自我验证信息',
	PRIMARY KEY (f_id),
	UNIQUE KEY unq_user_id (f_user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '用户密码表';

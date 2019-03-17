CREATE DATABASE IF NOT EXISTS bud_user DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_unicode_ci;

drop table  if exists t_user ;
create table t_user (
  f_id      bigint(20) unsigned auto_increment COMMENT '主键ID',
  f_create  bigint(20) unsigned not null default '0' COMMENT '创建时间戳',
  f_update  bigint(20) unsigned not null default '0' COMMENT '更新时间戳',
  f_version bigint(20) unsigned not null default '0' COMMENT '版本号',
  f_state   tinyint(3) unsigned not null default '0' COMMENT '用户状态:0可用，1禁止登录，2已注销',
  f_uid     bigint(20) unsigned not null default '0' COMMENT 'UID',
  unique key uniq_user_uid (f_uid),
  primary key(f_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='唯一用户表';
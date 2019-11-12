-- 创建数据库
CREATE DATABASE `security_db` CHARACTER SET utf8 COLLATE utf8_general_ci;

USE security_db ;

-- 用户表
CREATE TABLE sys_user (
  user_id INT (10) AUTO_INCREMENT PRIMARY KEY,
  -- 主键
  username VARCHAR (50),
  -- 用户名
  true_name VARCHAR (50),
  -- 真实姓名
  `password` VARCHAR (64) NOT NULL,
  -- 密码
  last_login TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  -- 最后登录时间
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  -- 创建时间
  enabled INT (5),
  -- 是否可用
  account_non_expired INT (5),
  -- 是否过期
  account_non_locked INT (5),
  -- 是否锁定
  credentials_non_expired INT (5) -- 证书是否过期
) ;

-- 权限表
CREATE TABLE sys_permission (
  perm_id INT (15) AUTO_INCREMENT PRIMARY KEY,
  -- 权限id
  perm_tag VARCHAR (30),
  -- 权限标识
  perm_desc VARCHAR (45)
  -- 权限说明
) ;

-- 角色表
CREATE TABLE sys_role (
  role_id INT (15) AUTO_INCREMENT PRIMARY KEY,
  -- 角色id
  role_name VARCHAR (32),
  -- 角色名称
  role_desc VARCHAR (255) -- 角色描述
) ;

--用户角色表
CREATE TABLE sys_user_role (
  user_id INT (10),
  -- 用户表主键id
  role_id INT (15) -- 角色表主键id
) ;

-- 角色权限表
CREATE TABLE sys_role_permission (
  role_id INT (15),
  -- 角色id
  perm_id INT (15) -- 权限id
) ;

-- 两个用户
INSERT INTO sys_user VALUES(NULL,'jack','张三','1234',NOW(),NOW(),1,1,1,1) ;
INSERT INTO sys_user VALUES(NULL,'hellxz','张三丰','5678',NOW(),NOW(),1,1,1,1) ;

-- 两个角色
INSERT INTO sys_role VALUES(NULL, '普通用户', '普通用户');
INSERT INTO sys_role VALUES(NULL, '管理员', '管理员用户');

-- 商品crud权限
INSERT INTO sys_permission VALUES(NULL, 'ROLE_PRODUCT_ADD','添加商品权限');
INSERT INTO sys_permission VALUES(NULL, 'ROLE_PRODUCT_DEL', '删除商品权限');
INSERT INTO sys_permission VALUES(NULL, 'ROLE_PRODUCT_MOD', '修改商品权限');
INSERT INTO sys_permission VALUES(NULL, 'ROLE_PRODUCT_GET', '查询商品权限');

-- jack是普通用户，hellxz是管理员用户
INSERT INTO sys_user_role VALUES(1,1);
INSERT INTO sys_user_role VALUES(2,2);

-- 普通用户只有查询权限
INSERT INTO sys_role_permission VALUES(1,4);
INSERT INTO sys_role_permission VALUES(2,1);
INSERT INTO sys_role_permission VALUES(2,2);
INSERT INTO sys_role_permission VALUES(2,3);
INSERT INTO sys_role_permission VALUES(2,4);

--select * from sys_role;
--select * from sys_user_role;
--select * from sys_permission;
--select * from sys_user;
--select * from sys_role_permission;

select permission.* from sys_user user
        left join sys_user_role user_role on user.user_id = user_role.user_id
        left join sys_role_permission role_permission on user_role.role_id = role_permission.role_id
        left join sys_permission permission on role_permission.perm_id = permission.perm_id
        where user.username = 'jack'

commit;
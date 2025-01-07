CREATE TABLE appx (
                      app_id INT IDENTITY(1,1) NOT NULL  COMMENT '应用ID',
                      app_key VARCHAR(40)  NULL COMMENT '应用访问KEY',
                      akey VARCHAR(40)  NULL COMMENT '（用于取代app id 形成的唯一key） //一般用于推广注册之类',
                      ugroup_id INT  DEFAULT 0 COMMENT '加入的用户组ID',
                      agroup_id INT  NULL COMMENT '加入的应用组ID',
                      name VARCHAR(50)  NULL COMMENT '应用名称',
                      note VARCHAR(50)  NULL COMMENT '应用备注',
                      ar_is_setting INT NOT NULL DEFAULT 0 COMMENT '是否开放设置',
                      ar_is_examine INT NOT NULL DEFAULT 0 COMMENT '是否审核中(0: 没审核 ；1：审核中)',
                      ar_examine_ver INT NOT NULL DEFAULT 0 COMMENT '审核 中的版本号',
                      log_fulltime DATETIME NULL,
                      PRIMARY KEY (app_id)
);
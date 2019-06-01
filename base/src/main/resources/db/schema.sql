DROP TABLE IF EXISTS t_kv_config;
CREATE TABLE t_kv_config (
    f_id BIGINT NOT NULL,
    f_key VARCHAR(256) NOT NULL,
    f_value VARCHAR(4096) NOT NULL,
    PRIMARY KEY (f_id),
		UNIQUE KEY `unq_key` (`f_key`)
);

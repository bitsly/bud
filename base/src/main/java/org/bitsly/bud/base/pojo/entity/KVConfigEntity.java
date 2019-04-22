package org.bitsly.bud.base.pojo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class KVConfigEntity implements Serializable {
    private Long id;
    private String key;
    private String value;
}

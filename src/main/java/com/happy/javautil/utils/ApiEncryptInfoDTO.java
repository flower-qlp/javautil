package com.happy.javautil.utils;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApiEncryptInfoDTO implements Serializable {

    private static final long serialVersionUID = 255205006827117733L;

    /**
     * 加密类型（2:sm2加密，4:sm4加密）
     */
    private String type;

    /**
     * 非对称加密私钥
     */
    private String privateKey;

    /**
     * 非对称加密公钥
     */
    private String publicKey;

    /**
     * 对称加密密钥
     */
    private String key;

    /**
     * 原始数据
     */
    private String data;

    /**
     * 加密后数据
     */
    private String dataHex;

    /**
     * 非对称加密签名
     */
    private String sign;
}


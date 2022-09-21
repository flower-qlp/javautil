package com.happy.javautil.utils;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.BCUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.crypto.engines.SM2Engine;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;

import java.nio.charset.StandardCharsets;

@Slf4j
public class SM2Utils {

    /**
     * SM2加密
     *
     * @param dto 包含加解密相关参数信息的实体
     * @return 处理结果
     */
    public static ApiEncryptInfoDTO encrypt2Data(ApiEncryptInfoDTO dto){
        String publicKey = dto.getPublicKey();
        // 若为空，使用默认
        if (StringUtils.isBlank(publicKey)) {
            publicKey = "04db9629dd33ba568e9507add5df6587a0998361a03d3321948b448c653c2c1b7056434884ab6f3d1c529501f166a336e86f045cea10dffe58aa82ea13d7253763";
        }
        String data = dto.getData();
        //创建sm2 对象
        SM2 sm2 = getSM2(null, publicKey);
        String dataHex = sm2.encryptBcd(data, KeyType.PublicKey);
        dto.setDataHex(dataHex);
        return dto;
    }

    /**
     * SM2解密
     * @param dto 包含加解密相关参数信息的实体
     * @return 处理结果
     */
    public static ApiEncryptInfoDTO decrypt2Data(ApiEncryptInfoDTO dto){
        String privateKey = dto.getPrivateKey();
        // 若为空，使用默认
        if (StringUtils.isBlank(privateKey)) {
//            privateKey = "1ebf8b341c695ee456fd1a41b82645724bc25d79935437d30e7e4b0a554baa5e";
            privateKey="387df37cef89ffb053dfb6042380a0edcfcf10b6103b8d59fbba2a94cb86b8f7";
        }
        String dataHex = dto.getDataHex();
        try {
            //创建sm2 对象
            SM2 sm2 = getSM2(privateKey, null);
            String data = StrUtil.utf8Str(sm2.decryptFromBcd(dataHex, KeyType.PrivateKey));
            dto.setData(data);
        } catch (Exception e) {
            log.error("SM2解密失败", e);
        }
        return dto;
    }

    /**
     * SM4加密
     *
     * @param dto 包含加解密相关参数信息的实体
     * @return 处理结果
     */
    public static ApiEncryptInfoDTO encrypt4Data(ApiEncryptInfoDTO dto) {
        //指定的密钥
        String key = dto.getKey();
        // 若为空，使用默认
        if (StringUtils.isBlank(key)) {
            key = "zps9yv341b3s90c2";
        }
        String data = dto.getData();
        try {
            SymmetricCrypto sm4 = SmUtil.sm4(key.getBytes(CharsetUtil.CHARSET_UTF_8));
            String dataHex = sm4.encryptHex(data);
            dto.setDataHex(dataHex);
        } catch (Exception e) {
            log.error("加密数据异常，异常数据：" + data, e);
        }
        return dto;
    }

    /**
     * SM4解密
     *
     * @param dto 包含加解密相关参数信息的实体
     * @return 处理结果
     */
    public static ApiEncryptInfoDTO decrypt4Data(ApiEncryptInfoDTO dto) {
        //指定的密钥
        String key = dto.getKey();
        // 若为空，使用默认
        if (StringUtils.isBlank(key)) {
            key = "zps9yv341b3s90c2";
        }
        String dataHex = dto.getDataHex();
        try {
            SymmetricCrypto sm4 = SmUtil.sm4(key.getBytes(CharsetUtil.CHARSET_UTF_8));
            String data = sm4.decryptStr(dataHex);
            dto.setData(data);
        } catch (Exception e) {
            log.error("解密数据异常，异常数据：" + dataHex, e);
        }
        return dto;
    }

    /**
     * 获取SM2加密工具对象
     *
     * @param privateKey 加密私钥
     * @param publicKey  加密公钥
     * @return 处理结果
     */
    private static SM2 getSM2(String privateKey, String publicKey) {
        ECPrivateKeyParameters ecPrivateKeyParameters = null;
        ECPublicKeyParameters ecPublicKeyParameters = null;
        if (StringUtils.isNotBlank(privateKey)) {
            ecPrivateKeyParameters = BCUtil.toSm2Params(privateKey);
        }
        if (StringUtils.isNotBlank(publicKey)) {
            if (publicKey.length() == 130) {
                //这里需要去掉开始第一个字节 第一个字节表示标记
                publicKey = publicKey.substring(2);
            }
            String xhex = publicKey.substring(0, 64);
            String yhex = publicKey.substring(64, 128);
            ecPublicKeyParameters = BCUtil.toSm2Params(xhex, yhex);
        }
        //创建sm2 对象
        SM2 sm2 = new SM2(ecPrivateKeyParameters, ecPublicKeyParameters);
        sm2.usePlainEncoding();
        sm2.setMode(SM2Engine.Mode.C1C2C3);
        return sm2;
    }

    /**
     * 生成一对 C1C2C3 格式的SM2密钥
     *
     * @return 处理结果
     */
    public static ApiEncryptInfoDTO getSM2Key() {
        ApiEncryptInfoDTO dto = new ApiEncryptInfoDTO();
        //创建sm2 对象
        SM2 sm2 = SmUtil.sm2();
        byte[] privateKeyByte = BCUtil.encodeECPrivateKey(sm2.getPrivateKey());
        //这里公钥不压缩  公钥的第一个字节用于表示是否压缩  可以不要
        byte[] publicKeyByte = ((BCECPublicKey) sm2.getPublicKey()).getQ().getEncoded(false);
        try {
            String privateKey = HexUtil.encodeHexStr(privateKeyByte);
            String publicKey = HexUtil.encodeHexStr(publicKeyByte);
            dto.setPublicKey(publicKey);
            dto.setPrivateKey(privateKey);
        } catch (Exception e) {
            log.error("获取SM2密钥出错", e);
        }
        return dto;
    }

    /**
     * 获取一个随机的SM4密钥
     *
     * @return 处理结果
     */
    public static ApiEncryptInfoDTO getSM4Key() {
        String sm4Key = RandomUtil.randomString(RandomUtil.BASE_CHAR_NUMBER, 16);
        ApiEncryptInfoDTO dto = new ApiEncryptInfoDTO();
        dto.setKey(sm4Key);
        return dto;
    }

    public static void main(String[] args) {
        String publicKey="043DB2670BE73F6E9DAB374E1B4F86D6DA886C66E69E2742D826DB90295E173E64D8844C36E6014E21C74CA13C78011C007046F504024BD47C60C41981F140513F";
        SM2 sm2Public=new SM2(null,publicKey);


        String encryptData="04B0E73F2C1B0BD41DBF696E103392F07DEBCF166C4438F21144985243CC797B9BC255DC850F84BD702054F35F3F4950D9A6210E5838CC9B723ED6B0251BAB901B94A1CA123006FEBA361404EEAD2C5245CB203C4BF466DD79A63668827D49A41058692109AFD9064AB166BE8DB9BE68D36F57EFBFBBA36DC9B425D0D3736EF2A5";
        String privateKey="00A1C953D347D0D7F2D0F6D753345713DC3E35AA9F71338B6373C0A600A6C36EF5";

        SM2 sm2=new SM2(privateKey,null,null);

        byte[] decrypt = sm2.decrypt(encryptData, KeyType.PrivateKey);

        System.out.println(new String(decrypt, StandardCharsets.UTF_8));



    }
}


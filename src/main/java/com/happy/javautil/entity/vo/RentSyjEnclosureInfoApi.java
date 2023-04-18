package com.happy.javautil.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * 附件信息
 * <p>
 * Author liulijia date 2023/3/10 16:09
 */
@Data
public class RentSyjEnclosureInfoApi {

    /**
     * 毕 业 证 / 学 位 证图片数组 最多 2 张
     */
    private List<RentSyjImgApi> degreeCertArray;

    /**
     * 合同图片数组 employmentFlag=Y 时必填，最多5张
     */
    private List<RentSyjImgApi> laborContractArray;

    /**
     * 学历认证图片数组 最多 2 张
     */
    private List<RentSyjImgApi> academicCertArray;

    /**
     * 其他证件图片数组 最多 2 张
     */
    private List<RentSyjImgApi> otherCertArray;

}

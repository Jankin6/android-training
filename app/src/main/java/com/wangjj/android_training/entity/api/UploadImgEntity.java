package com.wangjj.android_training.entity.api;

import com.wangjj.android_training.entity.BaseEntity;

/**
 * Created by wangjianjun on 17/4/18.
 */

public class UploadImgEntity extends BaseEntity {
    private String headImgUrl;

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }
}

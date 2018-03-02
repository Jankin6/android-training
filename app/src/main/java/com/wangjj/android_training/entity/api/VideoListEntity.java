package com.wangjj.android_training.entity.api;

import com.wangjj.android_training.entity.BaseEntity;

import java.util.List;

/**
 * Created by wangjianjun on 17/4/14.
 */

public class VideoListEntity extends BaseEntity {
    private int ret;
    private List<SubjectResulte> data;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public List<SubjectResulte> getData() {
        return data;
    }

    public void setData(List<SubjectResulte> data) {
        this.data = data;
    }

    public class SubjectResulte {
        private int id;
        private String name;
        private String title;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}

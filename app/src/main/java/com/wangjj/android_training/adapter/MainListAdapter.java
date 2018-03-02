package com.wangjj.android_training.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wangjj.android_training.R;

import java.util.List;

/**
 * Created by wangjianjun on 16/12/29.
 */

public class MainListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public MainListAdapter(List<String> data) {
        super(R.layout.item_main_list, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, String s) {
        holder.setText(R.id.tv_name, s);
    }
}

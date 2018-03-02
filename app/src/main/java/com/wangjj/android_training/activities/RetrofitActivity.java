package com.wangjj.android_training.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.wangjj.android_training.MyLog;
import com.wangjj.android_training.R;
import com.wangjj.android_training.api.http.ProgressSubscriber;
import com.wangjj.android_training.api.http.ServiceExecutor;
import com.wangjj.android_training.api.http.ServiceGenerator;
import com.wangjj.android_training.api.http.service.TestService;
import com.wangjj.android_training.api.http.service.UploadService;
import com.wangjj.android_training.entity.api.UploadImgEntity;
import com.wangjj.android_training.entity.api.VideoListEntity;
import com.wangjj.android_training.utils.ToastUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by wangjianjun on 17/4/14.
 */

public class RetrofitActivity extends BaseActivity {
    @BindView(R.id.tv_request)
    TextView mTvRequest;
    @BindView(R.id.btn_upload)
    Button mBtnUpload;
    @BindView(R.id.tv_upload_progress)
    TextView mTvUploadProgress;
    @BindView(R.id.btn_download)
    Button mBtnDownload;
    @BindView(R.id.btn_control)
    Button mBtnControl;
    @BindView(R.id.tv_download_progress)
    TextView mTvDownloadProgress;


    @Override
    protected void initVariables(Bundle savedInstanceState) {

    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
    }

    @Override
    protected void loadData() {
        mTvRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestService service = ServiceGenerator.createService(TestService.class);
                if (service != null) {
                    ServiceExecutor.getInstance().execute(service.getAllVedioBy(true), new ProgressSubscriber<VideoListEntity>(RetrofitActivity.this) {
                        @Override
                        public void _onNext(VideoListEntity videoListEntity) {
                            MyLog.WANGJJ.i(new Gson().toJson(videoListEntity));
                        }

                        @Override
                        public void _onError(Throwable e) {

                        }
                    });
                }
            }
        });
    }

    @OnClick(R.id.btn_upload)
    void clickUpload() {
        File file = new File("/storage/emulated/0/Download/11.JPEG");
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpeg"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("file", file.getName(), requestBody);

        RequestBody uid = RequestBody.create(MediaType.parse("text/plain"), "4811420");
        RequestBody key = RequestBody.create(MediaType.parse("text/plain"), "cfed6cc8caad0d79ea56d917376dc4df");

        ServiceExecutor.getInstance().execute(ServiceGenerator.createService(UploadService.class).uploadImage(uid, key, part), new ProgressSubscriber<UploadImgEntity>(this) {
            @Override
            public void _onNext(UploadImgEntity uploadImgEntity) {
                ToastUtil.showToastMessage("上传成功！");
            }

            @Override
            public void _onError(Throwable e) {

            }
        });


        Map<String, RequestBody> params = new HashMap<>();


        File[] files = new File[]{file, file};
        for (int i = 0; i < files.length; i++) {
            RequestBody requestBody2 = RequestBody.create(MediaType.parse("multipart/form-data"), files[i]);
            params.put("file[]\"; filename=\"" + files[i].getName() + "", requestBody);
        }

    }

    @OnClick(R.id.btn_download)
    void clickDownload(){

    }

}

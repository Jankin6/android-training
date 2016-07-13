package com.wangjj.android_training.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wangjj on 2016/7/3.
 */
public class UserModel implements Parcelable{
    public String username;
    public String password;

    public UserModel(){}
    public UserModel(String username, String password){
        this.username = username;
        this.password = password;
    }

    protected UserModel(Parcel in) {
        username = in.readString();
        password = in.readString();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(password);
    }
}

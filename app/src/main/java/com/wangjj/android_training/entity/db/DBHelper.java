package com.wangjj.android_training.entity.db;

import com.wangjj.android_training.MyApplication;

/**
 * Created by zhangyipeng on 16/7/13.
 */
public class DBHelper {

    public static final String DB_NAME = "traning.db";


    private static DBHelper instance;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    private DBHelper() {
    }

    public static DBHelper getInstance() {
        if (instance == null) {
            synchronized (DBHelper.class) {
                if (instance == null) {
                    instance = new DBHelper();
                }
            }
        }
        return instance;
    }


    /**
     * 取得DaoMaster
     *
     * @return
     */
    public DaoMaster getDaoMaster() {
        if (daoMaster == null) {
            DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(MyApplication.getInstance(), DB_NAME, null);
            daoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return daoMaster;
    }

    /**
     * 取得DaoSession
     *
     * @return
     */
    public DaoSession getDaoSession() {
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster();
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

    public DownInfoDao getDownInfoDao() {
        return getDaoSession().getDownInfoDao();
    }


}

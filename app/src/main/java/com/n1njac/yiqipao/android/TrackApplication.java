package com.n1njac.yiqipao.android;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.trace.LBSTraceClient;
import com.baidu.trace.LocationMode;
import com.baidu.trace.Trace;
//import org.litepal.LitePal;
import org.litepal.LitePal;

import java.lang.ref.WeakReference;

import cn.bmob.push.BmobPush;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobInstallation;

public class TrackApplication extends Application {

    private Context mContext = null;


    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        mContext = getApplicationContext();
        LitePal.initialize(this);
        Bmob.initialize(this, "eca43c1e6d34df771a7fa797a7960feb");
        BmobInstallation.getCurrentInstallation().save();
        BmobPush.startWork(this);
    }
}

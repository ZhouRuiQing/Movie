package com.bw.movie.app;

import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

public class Myapp extends MultiDexApplication{


    private static final String APP_ID = "wxb3852e6a6b7d9516";    //这个APP_ID就是注册APP的时候生成的

    private static final String APP_SECRET = "12312312313212313213213";
    private static Myapp app;

    public IWXAPI api;      //这个对象是专门用来向微信发送数据的一个重要接口,使用强引用持有,所有的信息发送都是基于这个对象的
    public static IWXAPI mWxApi;

    public static Myapp getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        initLoder();
        initzxing();
        app=this;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }
        MultiDex.install(this);

       /* //微信注册appid
        registerWeChat(this);*/
       registToWX();
    }

    private void registToWX() {
        //AppConst.WEIXIN.APP_ID是指你应用在微信开放平台上的AppID，记得替换。
        mWxApi = WXAPIFactory.createWXAPI(this, APP_ID, false);
        // 将该app注册到微信
        mWxApi.registerApp(APP_ID);
    }


    public void registerWeChat(Context context) {   //向微信注册app
        api = WXAPIFactory.createWXAPI(context, APP_ID, true);
        api.registerApp(APP_ID);
    }



    private void initzxing() {

        ZXingLibrary.initDisplayOpinion(this);
    }

    private void initLoder() {
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration
                .Builder(getApplicationContext())
                .defaultDisplayImageOptions(createOption())
                .build();
        ImageLoader.getInstance().init(configuration);


    }

    private DisplayImageOptions createOption() {

        DisplayImageOptions options = new DisplayImageOptions
                .Builder()
                .cacheInMemory(true)    // 开启内存缓存
                .cacheOnDisk(true)      // 开启存储卡缓存
                .build();
        return options;
    }
}

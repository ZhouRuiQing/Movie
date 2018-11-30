package com.bw.movie.wxapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bw.movie.app.Myapp;
import com.bw.movie.eventbean.EventCode;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

import org.greenrobot.eventbus.EventBus;

public class WXEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {

    private static IWXAPI iwxapi;
    private static final String APP_ID ="wxb3852e6a6b7d9516";
    private static final int RETURN_MSG_TYPE_LOGIN = 1;//登录
    private static final int RETURN_MSG_TYPE_SHARE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_wxentry);

        //如果没回调onResp，八成是这句没有写
        Myapp.mWxApi.handleIntent(getIntent(),this);

       /* //如果没回调onResp，八成是这句没有写
        iwxapi=WXAPIFactory.createWXAPI(this,APP_ID,false);
        iwxapi.handleIntent(getIntent(),this);*/
    }


    // 微信发送请求到第三方应用时，会回调到该方法
    @Override
    public void onReq(BaseReq baseReq) {

        Log.i("onReq==", "onReq: ===="+baseReq);
    }

    @Override
    public void onResp(BaseResp baseResp) {
        //请求回调结果处理
            int type = baseResp.getType();
            if(type==RETURN_MSG_TYPE_LOGIN){
                //登录回调
                SendAuth.Resp resp = (SendAuth.Resp) baseResp;
                switch (resp.errCode){
                    case BaseResp.ErrCode.ERR_OK:
                        String code = resp.code;
                        Log.i("code", "onResp: ===="+code);
                        EventBus.getDefault().post(new EventCode(code));
                        finish();
                        break;
                    case BaseResp.ErrCode.ERR_AUTH_DENIED:
                        break;
                    case BaseResp.ErrCode.ERR_USER_CANCEL:
                        break;
                }
            }
        }
    }

    // 第三方应用发送到微信的请求处理后的响应结果，会回调到该方法
    //app发送消息给微信，处理返回消息的回调
/*    @Override
    public void onResp(BaseResp resp) {

        Log.i("onResp",""+resp.errStr);
        Log.i("onResp","错误码 : " + resp.errCode + "");
        switch (resp.errCode) {

            case BaseResp.ErrCode.ERR_AUTH_DENIED:
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                if (RETURN_MSG_TYPE_SHARE == resp.getType()){
                   // UIUtils.showToast("分享失败");
                    Toast.makeText(this, "分享失败", Toast.LENGTH_SHORT).show();

                } else{
                    //UIUtils.showToast("登录失败");
                    Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();

                }
                break;
            case BaseResp.ErrCode.ERR_OK:
                switch (resp.getType()) {
                    case RETURN_MSG_TYPE_LOGIN:
                        //拿到了微信返回的code,立马再去请求access_token
                        String code = ((SendAuth.Resp) resp).code;
                        Log.i("code==","code = " + code);
                       *//* Intent intent = new Intent(this,ReginActivity.class);
                        intent.putExtra("code",code);*//*
                        EventBus.getDefault().postSticky(code);
                        //就在这个地方，用网络库什么的或者自己封的网络api，发请求去咯，注意是get请求

                        break;

                    case RETURN_MSG_TYPE_SHARE:
                        //UIUtils.showToast("微信分享成功");
                        Toast.makeText(this, "微信分享成功", Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                }
                break;
        }

    }*/



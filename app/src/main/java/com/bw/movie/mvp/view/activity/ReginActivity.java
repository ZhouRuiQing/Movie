package com.bw.movie.mvp.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.bw.movie.IView.IRegView;
import com.bw.movie.IView.IWeiEView;
import com.bw.movie.R;
import com.bw.movie.app.Myapp;
import com.bw.movie.eventbean.EventCode;
import com.bw.movie.eventbean.MessageEvent;
import com.bw.movie.mvp.model.bean.RegBean;
import com.bw.movie.mvp.model.bean.WeEBean;
import com.bw.movie.mvp.model.utils.EncryptUtil;
import com.bw.movie.mvp.present.RegPresent;
import com.bw.movie.mvp.present.WeIePresent;
import com.tencent.mm.sdk.modelmsg.SendAuth;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReginActivity extends AppCompatActivity implements IRegView ,IWeiEView {

    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.tv_user)
    TextView tvUser;
    @BindView(R.id.but_login)
    Button butLogin;
    @BindView(R.id.iv_weixin)
    ImageView ivWeixin;
    @BindView(R.id.save_pwd)
    CheckBox savePwd;
    @BindView(R.id.zd_login)
    CheckBox zdLogin;
    private RegPresent regPresent;
    private ToggleButton btnYing;
    private String loginName;
    private String loginPwd;
    private String loencryptPwd;
    private SharedPreferences user;
    private WeIePresent weIePresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regin);
        ButterKnife.bind(this);

        initView();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    private void initView() {

        //登录
        regPresent = new RegPresent(this);

        //微信登录
        weIePresent = new WeIePresent(this);

    }

    /**
    * 点击事件
    * */

    @OnClick({R.id.btn_ying, R.id.tv_user, R.id.but_login, R.id.iv_weixin})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btn_ying:
                btnYing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        } else {
                            editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        }
                    }
                });
                break;
                //跳转注册
            case R.id.tv_user:
                Intent intent = new Intent(ReginActivity.this,UserActivity.class);
                startActivity(intent);
                break;
                //直接登录
            case R.id.but_login:
                HashMap<String,String> loginMap = new HashMap<>();
                loginName = editName.getText().toString();
                loginPwd = editPassword.getText().toString();

                if (TextUtils.isEmpty(loginName)) {
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    if (TextUtils.isEmpty(loginPwd)) {
                        Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    } else {
                        loencryptPwd = EncryptUtil.encrypt(loginPwd);
                        loginMap.put("phone",loginName);
                        loginMap.put("pwd",loencryptPwd);

                        Log.i("loginMap","loencryptPwd"+loginPwd);
                        regPresent.getReg(loginMap);
                    }
                }
                break;
            case R.id.iv_weixin:
                Log.i("iv_weixin", "onViewClicked: 点击了====");
                wxLogin();
                //Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
                break;
        }

    }


    private void wxLogin() {
        if (!Myapp.mWxApi.isWXAppInstalled()) {
            Toast.makeText(this, "您还未安装微信客户端", Toast.LENGTH_SHORT).show();
            return;
        }

            SendAuth.Req req = new SendAuth.Req();
            req.scope = "snsapi_userinfo";
            req.state = "wxb3852e6a6b7d9516";
            Myapp.mWxApi.sendReq(req);



    }

    //成功
    @Override
    public void success(RegBean regBean) {

        String status = regBean.getStatus();
        String message = regBean.getMessage();
        RegBean.ResultBean bean = regBean.getResult();
        if(status.equalsIgnoreCase("0000")){

            Toast.makeText(this, message+"登陆成功", Toast.LENGTH_SHORT).show();
            Log.i("message","登陆成功 message==="+"message");
            user = ReginActivity.this.getSharedPreferences("user", MODE_PRIVATE);

            SharedPreferences.Editor edit = user.edit();
            // boolean isLogin = user.getBoolean("isLogin", true);
            edit.putString("touicon",bean.getUserInfo().getHeadPic()).commit();
            edit.putString("name",bean.getUserInfo().getNickName()).commit();
            edit.putString("phone",loginName).commit();
            edit.putString("pwd",loginPwd).commit();
            edit.putInt("sex",bean.getUserInfo().getSex()).commit();
            edit.putLong("birthday",bean.getUserInfo().getBirthday()).commit();

            //edit.putString("email",bean.getUserInfo().getLastLoginTime())
            edit.putInt("userId",bean.getUserId());
            edit.putString("sessionId",bean.getSessionId());
            edit.putBoolean("isLogin",true).commit();
            EventBus.getDefault().post(new MessageEvent(4));

            finish();
        }else{
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public void success(WeEBean weEBean) {
        String status = weEBean.getStatus();
        String message = weEBean.getMessage();

        Log.i("message", "success: ==="+message+status);
        WeEBean.ResultBean bean = weEBean.getResult();
        //Log.i("message", "success: ==="+bean.getUserInfo().toString());
        if(status.equalsIgnoreCase("0000")){

            Toast.makeText(this, message+"登陆成功", Toast.LENGTH_SHORT).show();
            Log.i("message","登陆成功 message==="+"message");
            user = ReginActivity.this.getSharedPreferences("user", MODE_PRIVATE);

            SharedPreferences.Editor edit = user.edit();
            //boolean isLogin = user.getBoolean("isLogin", true);
            edit.putString("touicon",bean.getUserInfo().getHeadPic()).commit();
            edit.putString("name",bean.getUserInfo().getNickName()).commit();
            edit.putString("phone",loginName).commit();
            edit.putString("pwd",loginPwd).commit();
            edit.putInt("sex",bean.getUserInfo().getSex()).commit();
            edit.putLong("birthday",bean.getUserInfo().getBirthday()).commit();

            //edit.putString("email",bean.getUserInfo().getLastLoginTime())
            edit.putInt("userId",bean.getUserId());
            edit.putString("sessionId",bean.getSessionId());
            edit.putBoolean("isLogin",true).commit();
            EventBus.getDefault().post(new MessageEvent(4));

            finish();
        }else{
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void Error(String msg) {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void getEvent(EventCode eventCode) {

        String code = eventCode.getCode();
        weIePresent.getWeiE(code);
        Log.i("code", "getEvent: ===="+code);

    }
}

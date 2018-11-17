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

import com.bw.movie.R;
import com.bw.movie.eventbean.MessageEvent;
import com.bw.movie.mvp.model.bean.RegBean;
import com.bw.movie.mvp.model.utils.EncryptUtil;
import com.bw.movie.mvp.present.RegPresent;
import com.bw.movie.mvp.view.IView.IRegView;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReginActivity extends AppCompatActivity implements IRegView {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regin);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {

        regPresent = new RegPresent(this);

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

                break;
        }

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
            edit.putInt("sex",bean.getUserInfo().getSex()).commit();
            edit.putLong("birthday",bean.getUserInfo().getBirthday()).commit();

            //edit.putString("email",bean.getUserInfo().getLastLoginTime())
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
}

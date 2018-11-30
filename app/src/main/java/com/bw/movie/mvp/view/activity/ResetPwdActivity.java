package com.bw.movie.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.ModifyPwdBean;
import com.bw.movie.mvp.model.utils.EncryptUtil;
import com.bw.movie.mvp.present.ModifyPwdPresent;
import com.bw.movie.IView.IModifyPwdView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResetPwdActivity extends AppCompatActivity implements IModifyPwdView {

    @BindView(R.id.oldPwd)
    EditText oldPwd;
    @BindView(R.id.newPwd)
    EditText newPwd;
    @BindView(R.id.newPwd2)
    EditText newPwd2;
    @BindView(R.id.btn_modifi)
    Button btnModifi;
    private ModifyPwdPresent modifyPwdPresent;
    private String newpwd;
    private String newpwd2;
    private SharedPreferences user;
    private String pwdEncrypt;
    private String pwdEncrypt2;
    private String userName;
    private String originalPsw, newPsw, newPswAgain;
    private String oldpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pwd);
        ButterKnife.bind(this);

        //initData();
        initView();




    }


    @OnClick(R.id.btn_modifi)
    public void onViewClicked() {

        HashMap<String, String> hashMap = new HashMap<>();
        String oldpwd1 = oldPwd.getText().toString();
        String newpw2 = newPwd.getText().toString();
        String newpwd23 = newPwd2.getText().toString();

        oldpwd = EncryptUtil.encrypt(oldpwd1);
        String newpwd = EncryptUtil.encrypt(newpw2);
        String newpwd2 = EncryptUtil.encrypt(newpwd23);

        hashMap.put("oldPwd", oldpwd);
        hashMap.put("newPwd",newpwd);
        hashMap.put("newPwd2",newpwd2);

        modifyPwdPresent.getModifyPwd(hashMap);
    }



    private void initData() {

        user = this.getSharedPreferences("user", Context.MODE_PRIVATE);
        final String oldpwd = user.getString("pwd", "");

        Log.i("oldpwd", "onClick: ===="+oldpwd);
        oldPwd.setText(oldpwd);
        EncryptUtil.encrypt(oldpwd);
        String name = user.getString("name", "");
        Log.i("initData", "initData: ==="+name);
        btnModifi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //String oldpwed = oldPwd.getText().toString();

                newpwd = newPwd.getText().toString();
                pwdEncrypt=EncryptUtil.encrypt(newpwd);
                newpwd2 = newPwd2.getText().toString();
                pwdEncrypt2=EncryptUtil.encrypt(newpwd2);

                boolean isLogin = user.getBoolean("isLogin", true);
                if (isLogin) {
                    //modifyPwdPresent.getModifyPwd(oldpwd, pwdEncrypt, pwdEncrypt2);
                    finish();
                } else {
                    Toast.makeText(ResetPwdActivity.this, "修改失败===", Toast.LENGTH_SHORT).show();

                }
            }

        });

    }

    private void initView() {

        modifyPwdPresent = new ModifyPwdPresent(this);

    }


    @Override
    public void success(ModifyPwdBean modifyPwdBean) {

        String message = modifyPwdBean.getMessage();
        String status = modifyPwdBean.getStatus();
        Log.i("success", "success: modifyPwdBean===="+modifyPwdBean.getMessage());
        if(message.equals("密码修改成功")&&status.equalsIgnoreCase("0000")){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ResetPwdActivity.this,ReginActivity.class));
            finish();
            Toast.makeText(this, "密码过期，请重新登录", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "修改失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void Error(String msg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        modifyPwdPresent.dettachView();
    }


}
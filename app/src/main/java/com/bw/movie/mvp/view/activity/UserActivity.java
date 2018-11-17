package com.bw.movie.mvp.view.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.UserBean;
import com.bw.movie.mvp.model.utils.EncryptUtil;
import com.bw.movie.mvp.present.UserPresent;
import com.bw.movie.mvp.view.IView.IUserView;
import com.gyf.barlibrary.ImmersionBar;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserActivity extends AppCompatActivity implements IUserView {

    @BindView(R.id.edit_name_user)
    EditText editNameUser;
    @BindView(R.id.edit_iphone_user)
    EditText editIphoneUser;
    @BindView(R.id.edit_password_user)
    EditText editPasswordUser;
    @BindView(R.id.tv_user)
    TextView tvUser;
    @BindView(R.id.but_user)
    Button butUser;
    @BindView(R.id.editRegisterPwd2)
    EditText editRegisterPwd2;
    @BindView(R.id.btn_boys)
    RadioButton btnBoys;
    @BindView(R.id.btn_girl)
    RadioButton btnGirl;
    @BindView(R.id.radioRegister)
    RadioGroup radioRegister;
    @BindView(R.id.editRegisterEmail)
    EditText editRegisterEmail;
    @BindView(R.id.editRegisterData)
    TextView editRegisterData;
    private UserPresent userPresent;
    private String name;
    private String number;
    private String pwd;
    private String pwd2;
    private String email;
    private String data;
    private String pwdEncrypt;
    private String pwd2Encrypt;
    private int setNum;
    private SharedPreferences user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);

        //沉浸式
        ImmersionBar.with(this).init();
        //选中性别赋数字
        radioRegister.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.btn_boys:
                        setNum=1;
                        break;
                    case R.id.btn_girl:
                        setNum=2;
                        break;
                }
            }
        });

        initView();
        initData();
    }

    private void initData() {

        editRegisterData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(UserActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        editRegisterData.setText(String.format("%d-%d-%d", year, monthOfYear + 1, dayOfMonth));
                    }
                }, 2000, 1, 2).show();
            }
        });



    }

    private void initView() {

        userPresent = new UserPresent(this);

    }

    @OnClick(R.id.but_user)
    public void onClickView(View v) {

        HashMap<String,String> map=new HashMap<>();
        name = editNameUser.getText().toString();
        number = editIphoneUser.getText().toString();
        pwd = editPasswordUser.getText().toString();
        pwd2 = editRegisterPwd2.getText().toString();
        email = editRegisterEmail.getText().toString();
        data = editRegisterData.getText().toString();

        if(!TextUtils.isEmpty(name)&&name.trim()!=""){
            if(!TextUtils.isEmpty(number)&number.trim()!=""&isMatcherFinded("^((13[0-9])|(15[0-9])|(18[0-9])|(17[0-9]))\\d{8}$",number)){
                if(!TextUtils.isEmpty(pwd)&pwd.trim()!=null){
                    if(!isMatcherFinded("^(?![\\d]+$)(?![a-zA-Z]+$)(?![^\\da-zA-Z]+$).{6,18}$",pwd)){
                        if(TextUtils.isEmpty(pwd)&pwd.trim()!=""){
                            Toast.makeText(this, "输入密码不能为空", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(this, "密码格式不对，必须密码(6-18个字母、字符、数字、相结合)", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        if(pwd.equals(pwd2)){
                            if(!isMatcherFinded("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$",email)){
                                if(TextUtils.isEmpty(email)&email.trim()!=""){
                                    Toast.makeText(this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(this, "邮箱格式不对", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                pwdEncrypt = EncryptUtil.encrypt(pwd);
                                pwd2Encrypt = EncryptUtil.encrypt(pwd2);
                                map.put("nickName",name);
                                map.put("phone",number);
                                map.put("pwd",pwdEncrypt);
                                Log.i("aaa", "onClickView: ===="+pwdEncrypt);
                                map.put("pwd2",pwd2Encrypt);
                                Log.i("aaa", "onClickView: ===="+pwd2Encrypt);
                                map.put("sex",setNum+"");
                                map.put("birthday",data);
                                map.put("email",email);

                                user = UserActivity.this.getSharedPreferences("user", MODE_PRIVATE);

                                SharedPreferences.Editor edit = user.edit();
                                edit.putString("name",name).commit();

                               userPresent.getUser(map);
                            }
                        }else{
                            if(pwd2.trim()!=""&TextUtils.isEmpty(pwd2)){
                                Toast.makeText(this, "输入的重复密码不能为空", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }else {
                    Toast.makeText(this, "输入密码不能为空", Toast.LENGTH_SHORT).show();
                }
            }else{
                if(TextUtils.isEmpty(number)&number.trim()==""){
                    Toast.makeText(UserActivity.this, "输入的账号不能为空", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(UserActivity.this, "必须是手机号", Toast.LENGTH_SHORT).show();
                }
            }
        }else{
            Toast.makeText(UserActivity.this, "昵称不能为空", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void success(UserBean registerBean) {

        String status = registerBean.getStatus();
        String message = registerBean.getMessage();
        if (status.equalsIgnoreCase("0000")) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(UserActivity.this, ReginActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }

    }

    //正则表达式
    public static boolean isMatcherFinded(String patternStr, CharSequence input) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return true;
        }
        return false;
    }
}

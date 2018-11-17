package com.bw.movie.mvp.view.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyMessageActivity extends AppCompatActivity {

    @BindView(R.id.iv_my_icon)
    ImageView ivMyIcon;
    @BindView(R.id.tv_my_name)
    TextView tvMyName;
    @BindView(R.id.tv_my_sex)
    TextView tvMySex;
    @BindView(R.id.tv_my_borhity)
    TextView tvMyBorhity;
    @BindView(R.id.tv_my_phone)
    TextView tvMyPhone;
    private SharedPreferences user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_message);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {

        tvMyBorhity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MyMessageActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvMyBorhity.setText(String.format("%d-%d-%d", year, monthOfYear + 1, dayOfMonth));
                    }
                }, 2000, 1, 2).show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        user = this.getSharedPreferences("user", Context.MODE_PRIVATE);

        String touicon = user.getString("touicon", "");
        String name = user.getString("name", "");
        int sex = user.getInt("sex", 0);
        long birthday = user.getLong("birthday", 0);
        String phone = user.getString("phone", "");

        if(sex==1){

            tvMySex.setText("男");
        }else {
            tvMySex.setText("女");
        }


        Date date = new Date(birthday);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        String databirthday = sd.format(date);

        Log.i("phone", "onResume:======= "+phone);

        Glide.with(this).load(touicon).into(ivMyIcon);
        tvMyName.setText(name);


        tvMyBorhity.setText(databirthday);
        tvMyPhone.setText(phone);

    }

    /**

     * 把毫秒转化成日期

     * @param dateFormat(日期格式，例如：MM/ dd/yyyy HH:mm:ss)

     * @param millSec(毫秒数)

     * @return

     */

    private String transferLongToDate(String dateFormat,Long millSec){

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

        Date date= new Date(millSec);

        return sdf.format(date);

    }
}

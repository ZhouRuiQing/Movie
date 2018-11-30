package com.bw.movie.mvp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.movie.IView.IFeedBackView;
import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.FeedBackBean;
import com.bw.movie.mvp.present.FeedBackPresent;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyFeedActivity extends AppCompatActivity implements IFeedBackView {

    @BindView(R.id.edit_feed)
    EditText editFeed;
    @BindView(R.id.edit_but)
    Button editBut;
    private FeedBackPresent feedBackPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_feed);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    private void initView() {
        feedBackPresent = new FeedBackPresent(this);

    }

    private void initData() {
        editBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editFeed.getText().equals("")){

                    Toast.makeText(MyFeedActivity.this, "请输入意见", Toast.LENGTH_SHORT).show();
                }else {
                    String edit_feed = editFeed.getText().toString();
                    feedBackPresent.getfeedback(edit_feed);
                }

                /*SharedPreferences user = getSharedPreferences("user", Context.MODE_PRIVATE);
                boolean isLogin = user.getBoolean("isLogin", true);
                if(isLogin){

                }else {
                    Toast.makeText(MyFeedActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
                }*/

            }
        });
    }


    @Override
    public void success(FeedBackBean feedBackBean) {

        String message = feedBackBean.getMessage();
        String status = feedBackBean.getStatus();
        Log.i("message", "success: FeedBackBean==="+message+status);
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,MyFeedsActivity.class));
    }

    @Override
    public void Error(String msg) {

    }
}

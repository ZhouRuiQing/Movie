package com.bw.movie.mvp.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.UserBuyBean;
import com.bw.movie.mvp.present.UserBuyPresent;
import com.bw.movie.mvp.view.IView.IUserBuyView;

import java.util.List;

public class ShopActivity extends AppCompatActivity implements IUserBuyView {


    private UserBuyPresent userBuyPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        initView();
    }

    private void initView() {

        userBuyPresent = new UserBuyPresent(this);
        userBuyPresent.getUserBuy(2, 10);
    }

    //购票记录
    @Override
    public void success(UserBuyBean userBuyBean) {

        List<UserBuyBean.ResultBean> list = userBuyBean.getResult();

        if(list==null){
            Toast.makeText(this, "集合里面没有数据", Toast.LENGTH_SHORT).show();
        }else {
            Log.i("success", "success: ===="+list.size());
        }

    }

    @Override
    public void Error(String msg) {

        Log.i("Error", "Error: ===="+msg);

    }
}

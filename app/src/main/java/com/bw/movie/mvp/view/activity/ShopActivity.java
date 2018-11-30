package com.bw.movie.mvp.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.bw.movie.IView.IUserBuyTickenView;
import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.UserBuyTicketBean;
import com.bw.movie.mvp.present.UserBuyTicketPresent;
import com.bw.movie.mvp.view.apdater.ShopApdater;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopActivity extends AppCompatActivity implements IUserBuyTickenView {


    @BindView(R.id.shop_Rcylcer_View)
    RecyclerView shopRcylcerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        UserBuyTicketPresent present = new UserBuyTicketPresent(this);
        present.getUserBuyTicket(1, 10);
    }

    //购票记录
    @Override
    public void success(UserBuyTicketBean userBuyTicketBean) {
        List<UserBuyTicketBean.ResultBean> list = userBuyTicketBean.getResult();
       // Toast.makeText(this, "集合"+list.size(), Toast.LENGTH_SHORT).show();
        if (list == null) {
            Toast.makeText(this, "集合里面没有数据", Toast.LENGTH_SHORT).show();
        } else {
            //Log.i("success", "success: ====" + list.size());
            Log.i("message==", "success: ==="+list.size());
            shopRcylcerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
            shopRcylcerView.setAdapter(new ShopApdater(list,this));
        }
    }

    @Override
    public void Error(String msg) {

        Log.i("Error", "Error: ====" + msg);

    }
}

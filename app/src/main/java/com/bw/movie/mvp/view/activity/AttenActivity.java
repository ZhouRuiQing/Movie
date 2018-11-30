package com.bw.movie.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.mvp.present.AttrnMoviePresent;
import com.bw.movie.mvp.view.apdater.MovieFragmentApdater;
import com.bw.movie.mvp.view.fregment.cinmensfragment.DetailsFragment;
import com.bw.movie.mvp.view.fregment.cinmensfragment.ReViewFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AttenActivity extends AppCompatActivity {

    @BindView(R.id.tab_atten)
    TabLayout tab;
    @BindView(R.id.vp_tablayout_atten)
    ViewPager vpTablayout;
    private AttrnMoviePresent attrnMoviePresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atten);
        ButterKnife.bind(this);

        SharedPreferences user = this.getSharedPreferences("user", Context.MODE_PRIVATE);
        boolean isLogin = user.getBoolean("isLogin", true);
         if(isLogin) {
             initView();
         }else {
             Toast.makeText(this, "请先登录", Toast.LENGTH_SHORT).show();
             startActivity(new Intent(this,ReginActivity.class));
             finish();
         }


    }


    private void initView() {
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new DetailsFragment());
        list.add(new ReViewFragment());
        MovieFragmentApdater myFragment = new MovieFragmentApdater(getSupportFragmentManager());
        myFragment.MyData(list);
        vpTablayout.setAdapter(myFragment);
        vpTablayout.setOffscreenPageLimit(list.size());
        tab.addTab(tab.newTab());
        tab.addTab(tab.newTab());

        tab.setupWithViewPager(vpTablayout);
        tab.getTabAt(0).setText("影片");
        tab.getTabAt(1).setText("影院");

    }

}

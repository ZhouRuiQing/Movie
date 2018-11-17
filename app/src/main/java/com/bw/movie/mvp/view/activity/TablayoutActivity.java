package com.bw.movie.mvp.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.bw.movie.R;
import com.bw.movie.mvp.view.apdater.MovieFragmentApdater;
import com.bw.movie.mvp.view.fregment.fragment.OneFragment;
import com.bw.movie.mvp.view.fregment.fragment.ThreFragment;
import com.bw.movie.mvp.view.fregment.fragment.TwoFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TablayoutActivity extends AppCompatActivity{

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp_tablayout)
    ViewPager vpTablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new OneFragment());
        list.add(new TwoFragment());
        list.add(new ThreFragment());
        MovieFragmentApdater myFragment = new MovieFragmentApdater(getSupportFragmentManager());
        myFragment.MyData(list);
        vpTablayout.setAdapter(myFragment);
        vpTablayout.setOffscreenPageLimit(list.size());
        tab.addTab(tab.newTab());
        tab.addTab(tab.newTab());
        tab.addTab(tab.newTab());

        tab.setupWithViewPager(vpTablayout);
        tab.getTabAt(0).setText("热门影片");
        tab.getTabAt(1).setText("正在上映");
        tab.getTabAt(2).setText("即将上映");

    }
    }

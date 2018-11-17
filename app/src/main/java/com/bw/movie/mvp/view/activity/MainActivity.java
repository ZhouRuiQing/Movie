package com.bw.movie.mvp.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.movie.R;
import com.bw.movie.mvp.view.fregment.CinemaFregment;
import com.bw.movie.mvp.view.fregment.MovieFregment;
import com.bw.movie.mvp.view.fregment.SetFragment;
import com.gyf.barlibrary.ImmersionBar;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

 /*   @BindView(R.id.rb_1)
    RadioButton rb1;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.rb_2)
    RadioButton rb2;
    @BindView(R.id.rb_3)
    RadioButton rb3;*/
 private BottomTabBar mBottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mBottomBar = findViewById(R.id.bottom_bar);
        ImmersionBar.with(this).init();
        mBottomBar.init(getSupportFragmentManager())
                //.setImgSize(100, 100)
                .setFontSize(0)
                .setTabBarBackgroundColor(0)
//              .setTabPadding(10, 6, 4)
//              .setChangeColor(Color.parseColor("#2784E7"),Color.parseColor("#282828"))
                //.setChangeColor(Color.RED,Color.GRAY)
                .addTabItem("影片",R.mipmap.com_icon_film_selected_xhdpi, R.mipmap.com_icon_film_fault_xhdpi,MovieFregment.class)
                .addTabItem("影院", R.mipmap.com_icon_cinema_selected_xhdpi,R.mipmap.com_icon_cinema_default_xhdpi, CinemaFregment.class)
                .addTabItem("设置",R.mipmap.com_icon_my_selected_xhdpi, R.mipmap.com_icon_my_default_xhdpi, SetFragment.class)
//                .isShowDivider(true)
//                .setDividerColor(Color.parseColor("#373737"))
//                .setTabBarBackgroundColor(Color.parseColor("#FFFFFF"))
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name, View view) {
                        if (position == 1)
                            mBottomBar.setSpot(1, false);
                    }
                })
                .setSpot(1, false)
                .setSpot(2, false);
    }

    public void setShowTabBar(boolean isShow){
        if (isShow){
            mBottomBar.getTabBar().setVisibility(View.VISIBLE);
        }else {
            mBottomBar.getTabBar().setVisibility(View.GONE);
        }

    }


    /*radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){

                    case R.id.rb_1:
                        Changpager(new MovieFregment());
                        break;
                    case R.id.rb_2:
                        Changpager(new CinemaFregment());
                        break;
                    case R.id.rb_3:
                        Changpager(new SetFragment());
                        break;

                }

            }
        });

        Changpager(new MovieFregment());

    }

    private void Changpager(Fragment fragment){

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();

    }*/

}

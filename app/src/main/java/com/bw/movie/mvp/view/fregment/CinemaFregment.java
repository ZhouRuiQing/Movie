package com.bw.movie.mvp.view.fregment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.mvp.view.activity.MapActivity;
import com.bw.movie.mvp.view.apdater.MovieFragmentApdater;
import com.bw.movie.mvp.view.fregment.fragments.NearByFragment;
import com.bw.movie.mvp.view.fregment.fragments.RecommendFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CinemaFregment extends Fragment {


    @BindView(R.id.tab_cinema)
    TabLayout tabCinema;
    @BindView(R.id.vp_cinema_tablayout)
    ViewPager vpCinemaTablayout;
    Unbinder unbinder;
    @BindView(R.id.cinmea_map)
    ImageView cinmeaMap;
    @BindView(R.id.cinema_city)
    TextView cinemaCity;

    public CinemaFregment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_cinema_fregment, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EventBus.getDefault().register(this);
        initView();
        initData();

    }

    private void initData() {

        cinmeaMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),MapActivity.class));
            }
        });

    }

    private void initView() {

        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new RecommendFragment());
        list.add(new NearByFragment());
        MovieFragmentApdater myFragment = new MovieFragmentApdater(getChildFragmentManager());
        myFragment.MyData(list);
        vpCinemaTablayout.setAdapter(myFragment);
        vpCinemaTablayout.setOffscreenPageLimit(list.size());

        tabCinema.addTab(tabCinema.newTab());
        tabCinema.addTab(tabCinema.newTab());
        tabCinema.setupWithViewPager(vpCinemaTablayout);
        tabCinema.getTabAt(0).setText("推荐影院");
        tabCinema.getTabAt(1).setText("附近影院");

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEvent(String city) {

        cinemaCity.setText(city);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

        EventBus.getDefault().unregister(this);
    }
}

package com.bw.movie.mvp.view.fregment.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.movie.IView.ICinemaAttenView;
import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.AttenCinemaBean;
import com.bw.movie.mvp.present.CinemaAttenPresent;
import com.bw.movie.mvp.present.CinemesPresent;
import com.bw.movie.mvp.view.apdater.AttenCinemaApdater;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends Fragment implements ICinemaAttenView {


    @BindView(R.id.Recommend_recyler_View)
    RecyclerView RecommendRecylerView;
    Unbinder unbinder;
    private CinemesPresent cinemesPresent;
    private CinemaAttenPresent cinemaAttenPresent;
    private AttenCinemaApdater attenCinemaApdater;

    public RecommendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_recommend, container, false);
        unbinder = ButterKnife.bind(this, inflate);

        return inflate;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    //初始化数据
    private void initData() {

    }

    //初始化视图
    private void initView() {

        /*cinemesPresent = new CinemesPresent(this);
        cinemesPresent.getCinemes(1, 15);*/


        //推荐的影院
        cinemaAttenPresent = new CinemaAttenPresent(this);
        cinemaAttenPresent.getCinemaAtten(1,10);

    }


    //推荐的电影
    @Override
    public void success(AttenCinemaBean attenCinemaBean) {

        List<AttenCinemaBean.ResultBean> list = attenCinemaBean.getResult();
        
        if(list==null){

            Toast.makeText(getActivity(), "请关注影院", Toast.LENGTH_SHORT).show();
        }else {
            RecommendRecylerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            attenCinemaApdater = new AttenCinemaApdater(getActivity(), list);
            RecommendRecylerView.setAdapter(attenCinemaApdater);
            attenCinemaApdater.notifyDataSetChanged();
        }


    }

    /*   @Override
    public void success(FindCinemesBean cinemesBean) {

        Log.i("aaa", cinemesBean.getResult().toString() + "");
        List<FindCinemesBean.ResultBean.NearbyCinemaListBean> list = cinemesBean.getResult().getNearbyCinemaList();
       *//*RecommendRecylerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        RecommendRecylerView.setAdapter(new RexommwndApdater(getActivity(), list));*//*

    }

*/


    @Override
    public void Error(String msg) {

        Log.i("Error", "Error: ===="+msg);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

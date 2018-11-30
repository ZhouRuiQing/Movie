package com.bw.movie.mvp.view.fregment.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.mvp.view.apdater.tabapdaters.FindApdater;
import com.bw.movie.mvp.model.bean.MovieFindinfo;
import com.bw.movie.mvp.present.FindPresent;
import com.bw.movie.IView.IFindView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment implements IFindView {


    @BindView(R.id.two_Rcecyler_View)
    RecyclerView twoRcecylerView;
    @BindView(R.id.simp_View)
    SmartRefreshLayout simpView;
    Unbinder unbinder;
    @BindView(R.id.two_return)
    ImageView twoReturn;
    private FindPresent findPresent;

    public TwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        twoReturn.bringToFront();
        twoReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().finish();
            }
        });

        EventBus.getDefault().register(this);
    }


    private void initView() {
        findPresent = new FindPresent(this);
        findPresent.getFindMovie(1, 20);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void success(MovieFindinfo movieFindinfo) {

        final List<MovieFindinfo.ResultBean> list = movieFindinfo.getResult();
        initFind(list);
    }

    private void initFind(List<MovieFindinfo.ResultBean> list) {
        FindApdater apdater = new FindApdater(getActivity(), list);
        twoRcecylerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        twoRcecylerView.setAdapter(apdater);
    }

    @Override
    public void Error(String msg) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEvent(Integer page){

        Log.i("getEvent","==="+page);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

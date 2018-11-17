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
import com.bw.movie.mvp.view.apdater.tabapdaters.MovieHotApdater;
import com.bw.movie.mvp.model.bean.Movieinfo;
import com.bw.movie.mvp.present.HotMoviePresent;
import com.bw.movie.mvp.view.IView.IHotMvoieView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment implements IHotMvoieView {


    @BindView(R.id.one_Rcecyler_View)
    RecyclerView oneRcecylerView;
    @BindView(R.id.simp_View)
    SmartRefreshLayout simpView;
    Unbinder unbinder;
    @BindView(R.id.one_return)
    ImageView oneReturn;
    private HotMoviePresent present;

    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        oneReturn.bringToFront();
        oneReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().finish();
            }
        });
    }

    private void initData() {
        present = new HotMoviePresent(this);
        present.getHoMovie(1, 20);
    }


    @Override
    public void success(Movieinfo movieinfo) {

        Log.i("aaa", movieinfo.getResult().toString() + "");
        final List<Movieinfo.ResultBean> list = movieinfo.getResult();
        OneMovie(list);
    }

    @Override
    public void Error(String msg) {

    }

    private void OneMovie(List<Movieinfo.ResultBean> list) {
        MovieHotApdater apdater = new MovieHotApdater(getActivity(), list);
        oneRcecylerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        oneRcecylerView.setAdapter(apdater);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

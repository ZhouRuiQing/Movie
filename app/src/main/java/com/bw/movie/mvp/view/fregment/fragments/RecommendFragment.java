package com.bw.movie.mvp.view.fregment.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.FindCinemesBean;
import com.bw.movie.mvp.present.CinemesPresent;
import com.bw.movie.mvp.view.IView.ICinemesView;
import com.bw.movie.mvp.view.apdater.RexommwndApdater;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends Fragment implements ICinemesView {


    @BindView(R.id.Recommend_recyler_View)
    RecyclerView RecommendRecylerView;
    Unbinder unbinder;
    private CinemesPresent cinemesPresent;

    public RecommendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_recommend, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        initView();
        return inflate;
    }

    private void initView() {

        cinemesPresent = new CinemesPresent(this);
        cinemesPresent.getCinemes(1, 15);
    }



    @Override
    public void success(FindCinemesBean cinemesBean) {

        Log.i("aaa", cinemesBean.getResult().toString() + "");
        List<FindCinemesBean.ResultBean.NearbyCinemaListBean> list = cinemesBean.getResult().getNearbyCinemaList();
        RecommendRecylerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        RecommendRecylerView.setAdapter(new RexommwndApdater(getActivity(), list));


    }

    @Override
    public void Error(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

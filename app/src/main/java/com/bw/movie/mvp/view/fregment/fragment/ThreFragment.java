package com.bw.movie.mvp.view.fregment.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.mvp.view.apdater.tabapdaters.ThreeComingApdater;
import com.bw.movie.mvp.model.bean.ComingMovie;
import com.bw.movie.mvp.present.ComingPresent;
import com.bw.movie.IView.IComingView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThreFragment extends Fragment implements IComingView {


    @BindView(R.id.simp_View)
    SmartRefreshLayout simpView;
    @BindView(R.id.three_Rcecyler_View)
    RecyclerView threeRcecylerView;
    Unbinder unbinder;
    @BindView(R.id.three_return)
    ImageView threeReturn;
    private ComingPresent comingPresent;

    public ThreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thre, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        threeReturn.bringToFront();
        threeReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().finish();
            }
        });
    }

    private void initView() {

        comingPresent = new ComingPresent(this);
        comingPresent.getComingMovie(1, 10);
    }

    @Override
    public void Sueecss(ComingMovie comingMovie) {

        final List<ComingMovie.ResultBean> list = comingMovie.getResult();
        ThreeComingApdater apdater = new ThreeComingApdater(getActivity(), list);
        threeRcecylerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        threeRcecylerView.setAdapter(apdater);
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

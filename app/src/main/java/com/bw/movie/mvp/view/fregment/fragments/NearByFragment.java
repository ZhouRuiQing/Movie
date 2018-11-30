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

import com.bw.movie.R;
import com.bw.movie.mvp.view.apdater.NeatMyApdater;
import com.bw.movie.mvp.model.bean.AllCinemasBean;
import com.bw.movie.mvp.present.AllCinemasPresent;
import com.bw.movie.IView.IAllCinemas;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class NearByFragment extends Fragment implements IAllCinemas {


    @BindView(R.id.near_Rcvylcer_View)
    RecyclerView nearRcvylcerView;
    Unbinder unbinder;
    private AllCinemasPresent allCinemasPresent;
    private String TAG = new String();

    public NearByFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_near_by, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
    }

    /**
     * 初始化数据
     */
    private void initView() {

        allCinemasPresent = new AllCinemasPresent(this);
        allCinemasPresent.getAllCinemas(1, 20);
    }

    @Override
    public void success(AllCinemasBean allCinemasBean) {

        List<AllCinemasBean.ResultBean> list = allCinemasBean.getResult();
        Log.i("success", "success: =====" + list.size());

        nearRcvylcerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        NeatMyApdater neatMyApdater = new NeatMyApdater(getActivity(), list);
        nearRcvylcerView.setAdapter(neatMyApdater);

        neatMyApdater.notifyDataSetChanged();
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

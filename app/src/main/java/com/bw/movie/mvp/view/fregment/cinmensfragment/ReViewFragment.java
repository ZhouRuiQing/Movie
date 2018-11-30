package com.bw.movie.mvp.view.fregment.cinmensfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.movie.IView.ICinemaAttenView;
import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.AttenCinemaBean;
import com.bw.movie.mvp.present.CinemaAttenPresent;
import com.bw.movie.mvp.view.apdater.AttenCinemaApdater;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReViewFragment extends Fragment implements ICinemaAttenView {


    @BindView(R.id.attenCinema_recylcer_View)
    RecyclerView attenCinemaRecylcerView;
    Unbinder unbinder;
    private CinemaAttenPresent cinemaAttenPresent;

    public ReViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_re_view, container, false);
        initView();
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    private void initView() {

        cinemaAttenPresent = new CinemaAttenPresent(this);
        cinemaAttenPresent.getCinemaAtten(1, 10);
    }

    //关注的影院
    @Override
    public void success(AttenCinemaBean attenCinemaBean) {

        List<AttenCinemaBean.ResultBean> list = attenCinemaBean.getResult();
        //Log.i("success", "success: ====" + list.size());
        if(list==null){
            Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
            //startActivity(new Intent(getActivity(),ReginActivity.class));
        }else {
            attenCinemaRecylcerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            attenCinemaRecylcerView.setAdapter(new AttenCinemaApdater(getActivity(),list));
        }
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

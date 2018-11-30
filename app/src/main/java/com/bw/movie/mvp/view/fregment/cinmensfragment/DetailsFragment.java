package com.bw.movie.mvp.view.fregment.cinmensfragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.AttenMovieBean;
import com.bw.movie.mvp.present.AttrnMoviePresent;
import com.bw.movie.IView.IAttenMovieView;
import com.bw.movie.mvp.view.activity.ReginActivity;
import com.bw.movie.mvp.view.apdater.AtrenMovieApdater;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment implements IAttenMovieView {


    @BindView(R.id.attenMovie_recylcer_View)
    RecyclerView attenMovieRecylcerView;
    Unbinder unbinder;
    private AttrnMoviePresent attrnMoviePresent;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_details, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        initView();
        return inflate;
    }

    private void initView() {

        attrnMoviePresent = new AttrnMoviePresent(this);
        attrnMoviePresent.getAttenMovie(1,10);
    }

    //我的关注
    @Override
    public void success(AttenMovieBean attenMovieBean) {

        List<AttenMovieBean.ResultBean> list = attenMovieBean.getResult();
        //Log.i("success", "success: ===="+list.size());

        if(list==null){
            Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
             startActivity(new Intent(getActivity(),ReginActivity.class));
        }else {
            attenMovieRecylcerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
            attenMovieRecylcerView.setAdapter(new AtrenMovieApdater(getActivity(),list));
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

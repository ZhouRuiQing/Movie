package com.bw.movie.mvp.view.fregment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.mvp.model.utils.GlideRoundTransform;
import com.bw.movie.mvp.view.activity.AttenActivity;
import com.bw.movie.mvp.view.activity.MyFeedActivity;
import com.bw.movie.mvp.view.activity.MyMessageActivity;
import com.bw.movie.mvp.view.activity.ReginActivity;
import com.bw.movie.mvp.view.activity.ShopActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SetFragment extends Fragment {


    @BindView(R.id.my_message)
    ImageView myMessage;
    @BindView(R.id.my_feed)
    ImageView myFeed;
    Unbinder unbinder;
    @BindView(R.id.my_iv_icon_head)
    ImageView ivIconHead;
    private SharedPreferences user;

    public SetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_set,container,false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.my_feed, R.id.my_message,R.id.my_iv_icon_head,R.id.my_goupiao,R.id.my_attention})
    public void onClickView(View v) {

        switch (v.getId()) {

            case R.id.my_iv_icon_head://进入登录注册页面
                startActivity(new Intent(getActivity(),ReginActivity.class));
                break;

            case R.id.my_message://我的信息
                startActivity(new Intent(getActivity(), MyMessageActivity.class));
                break;

            case R.id.my_feed://意见反馈
                startActivity(new Intent(getActivity(), MyFeedActivity.class));
                break;

            case R.id.my_goupiao://购票
                startActivity(new Intent(getActivity(),ShopActivity.class));
                break;

            case R.id.my_attention://关注
                startActivity(new Intent(getActivity(),AttenActivity.class));
                break;

        }
    }

    @Override
    public void onResume() {
        super.onResume();

        user = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        String touicon = user.getString("touicon", "");
        String phone = user.getString("phone", "");

        Log.i("onResume", "onResume: ===="+touicon.toString());
        Log.i("onResume", "onResume: ===="+phone.toString());
        Glide.with(getActivity()).load(touicon)
                .bitmapTransform(new GlideRoundTransform(getActivity(),35))
                .into(ivIconHead);
        //Toast.makeText(getActivity(), "touicon=== "+touicon, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

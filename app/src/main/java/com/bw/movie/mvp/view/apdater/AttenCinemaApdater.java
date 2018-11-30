package com.bw.movie.mvp.view.apdater;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.movie.IView.IUnAttenCinemaView;
import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.AttenCinemaBean;
import com.bw.movie.mvp.model.bean.AttenMovieBean;
import com.bw.movie.mvp.present.UnAttenCinemaPresent;

import java.util.List;

/**
 * 作者：轻 on 2018/11/21 11:43
 * <p>
 * 邮箱：379996854@qq.com
 */
public class AttenCinemaApdater extends RecyclerView.Adapter<MyRexommwnViewHoder> implements IUnAttenCinemaView {
    Context context;
    List<AttenCinemaBean.ResultBean> list;
    private boolean followCinema;
    private SharedPreferences user;
    private boolean isLogin;
    private UnAttenCinemaPresent unAttenCinemaPresent;
    private int id;

    public AttenCinemaApdater(Context context, List<AttenCinemaBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public MyRexommwnViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyRexommwnViewHoder hoder = new MyRexommwnViewHoder(LayoutInflater.from(context).inflate(R.layout.rexommend_item,parent,false));
        initView();
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyRexommwnViewHoder holder, int position) {

        Glide.with(context).load(list.get(position).getLogo()).into(holder.ivRxImage);
        holder.tvReName.setText(list.get(position).getName());
        holder.tvRxTitle.setText(list.get(position).getAddress());
        //holder.tvNearJuli.setText(list.get(position).get+"km");
        id = list.get(position).getId();
        AttenCinemaBean.ResultBean bean = list.get(position);
        followCinema = bean.isFollowCinema();

        user = context.getSharedPreferences("user", Context.MODE_PRIVATE);

        isLogin = user.getBoolean("isLogin", true);

        holder.ivRxGuanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == holder.ivRxGuanzhu) {

                    if (followCinema) {
                        Toast.makeText(context, "已经关注", Toast.LENGTH_SHORT).show();
                    } else {
                           /* holder.ivNearGuanzhu.setImageResource(R.drawable.guanzhu1);
                            attenCinemaPresent.getAttenCinema(id);*/
                        holder.ivRxGuanzhu.setImageResource(R.drawable.guanzhu);
                        unAttenCinemaPresent.getUnAttenCinema(id);
                    }
                    followCinema = !followCinema;
                }
            }
        });

        //notifyDataSetChanged();

    }

    private void initView() {

        //取消关注
        unAttenCinemaPresent = new UnAttenCinemaPresent(this);

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    //取消关注
    @Override
    public void success(AttenMovieBean attenMovieBean) {

        Log.i("success", "success: ====="+attenMovieBean.getMessage());

    }

    @Override
    public void Error(String msg) {

    }
}

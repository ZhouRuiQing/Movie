package com.bw.movie.mvp.view.apdater;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.movie.IView.IAttenCinemaView;
import com.bw.movie.IView.IUnAttenCinemaView;
import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.AllCinemasBean;
import com.bw.movie.mvp.model.bean.AttenBean;
import com.bw.movie.mvp.model.bean.AttenMovieBean;
import com.bw.movie.mvp.present.AttenCinemaPresent;
import com.bw.movie.mvp.present.UnAttenCinemaPresent;
import com.bw.movie.mvp.view.activity.CinemaInfoActivity;
import com.bw.movie.mvp.view.activity.ReginActivity;

import java.util.List;

/**
 * 作者：轻 on 2018/11/9 19:05
 * <p>
 * 邮箱：379996854@qq.com
 */
public class NeatMyApdater extends RecyclerView.Adapter<NearViewHodeer> implements IAttenCinemaView,IUnAttenCinemaView {
    Context context;
    List<AllCinemasBean.ResultBean> list;
    private AttenCinemaPresent attenCinemaPresent;
    private UnAttenCinemaPresent unAttenCinemaPresent;
    private SharedPreferences user;
    private boolean isLogin;
    private boolean followCinema;

    public NeatMyApdater(Context context, List<AllCinemasBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NearViewHodeer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NearViewHodeer hoder = new NearViewHodeer(LayoutInflater.from(context).inflate(R.layout.near_item,parent,false));
        initView();
        return hoder;
    }

    private void initView() {

        //关注
        attenCinemaPresent = new AttenCinemaPresent(this);

        //取消关注
        unAttenCinemaPresent = new UnAttenCinemaPresent(this);

    }

    @Override
    public void onBindViewHolder(@NonNull final NearViewHodeer holder, final int position) {

        Glide.with(context).load(list.get(position).getLogo()).into(holder.ivNearImage);
        holder.tvNearName.setText(list.get(position).getName());
        holder.tvNaerTitle.setText(list.get(position).getAddress());
        holder.tvNearJuli.setText(list.get(position).getDistance()+"km");
        final int id = list.get(position).getId();
        final AllCinemasBean.ResultBean bean = list.get(position);

        //final boolean[] followCinema = {bean.isFollowCinema()};
        followCinema = bean.isFollowCinema();
        user = context.getSharedPreferences("user", Context.MODE_PRIVATE);

        isLogin = user.getBoolean("isLogin", true);

        holder.ivNearGuanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == holder.ivNearGuanzhu) {

                    if (isLogin=true) {

                        if (followCinema) {
                            holder.ivNearGuanzhu.setImageResource(R.drawable.guanzhu);
                            unAttenCinemaPresent.getUnAttenCinema(id);

                        } else {
                            holder.ivNearGuanzhu.setImageResource(R.drawable.guanzhu1);
                            attenCinemaPresent.getAttenCinema(id);
                        }

                        followCinema = !followCinema;

                    }else{
                        Toast.makeText(context, "请先登录", Toast.LENGTH_SHORT).show();
                        context.startActivity(new Intent(context,ReginActivity.class));
                    }

                    isLogin=!isLogin;

                }


            }
        });


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CinemaInfoActivity.class);
                intent.putExtra("id", id);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    //关注
    @Override
    public void success(AttenBean attenBean) {

        Log.i("success", "success: ======"+attenBean.getMessage());
    }

    //取消关注
    @Override
    public void success(AttenMovieBean attenMovieBean) {
        Log.i("success", "success: ======"+attenMovieBean.getMessage());
    }

    @Override
    public void Error(String msg) {

    }
}

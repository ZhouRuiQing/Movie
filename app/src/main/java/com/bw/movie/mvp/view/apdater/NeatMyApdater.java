package com.bw.movie.mvp.view.apdater;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.AllCinemasBean;
import com.bw.movie.mvp.view.activity.CinemaInfoActivity;

import java.util.List;

/**
 * 作者：轻 on 2018/11/9 19:05
 * <p>
 * 邮箱：379996854@qq.com
 */
public class NeatMyApdater extends RecyclerView.Adapter<NearViewHodeer> {
    Context context;
    List<AllCinemasBean.ResultBean> list;

    public NeatMyApdater(Context context, List<AllCinemasBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NearViewHodeer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NearViewHodeer hoder = new NearViewHodeer(LayoutInflater.from(context).inflate(R.layout.near_item,parent,false));
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull final NearViewHodeer holder, final int position) {

        Glide.with(context).load(list.get(position).getLogo()).into(holder.ivNearImage);
        holder.tvNearName.setText(list.get(position).getName());
        holder.tvNaerTitle.setText(list.get(position).getAddress());
        holder.tvNearJuli.setText(list.get(position).getDistance()+"km");
        final AllCinemasBean.ResultBean bean = list.get(position);

        final boolean[] followCinema = {bean.isFollowCinema()};
        holder.ivNearGuanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v==holder.ivNearGuanzhu) {
                    if (followCinema[0]) {

                        holder.ivNearGuanzhu.setImageResource(R.drawable.guanzhu);
                    }else {
                        holder.ivNearGuanzhu.setImageResource(R.drawable.guanzhu1);
                    }

                   followCinema[0] =!followCinema[0];
                }
            }
        });


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CinemaInfoActivity.class);
                intent.putExtra("id",list.get(position).getId());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

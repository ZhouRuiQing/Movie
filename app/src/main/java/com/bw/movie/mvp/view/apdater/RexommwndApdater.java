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
import com.bw.movie.mvp.model.bean.FindCinemesBean;
import com.bw.movie.mvp.view.activity.CinemaInfoActivity;

import java.util.List;

public class RexommwndApdater extends RecyclerView.Adapter<MyRexommwnViewHoder> {
    Context context;
    List<FindCinemesBean.ResultBean.NearbyCinemaListBean> list;
    private boolean guanzhu=false;

    public RexommwndApdater(Context context, List<FindCinemesBean.ResultBean.NearbyCinemaListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyRexommwnViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyRexommwnViewHoder hoder = new MyRexommwnViewHoder(LayoutInflater.from(context).inflate(R.layout.rexommend_item,parent,false));
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyRexommwnViewHoder holder, final int position) {

        Glide.with(context).load(list.get(position).getLogo()).into(holder.ivRxImage);
        holder.tvReName.setText(list.get(position).getName());
        holder.tvRxTitle.setText(list.get(position).getAddress());
        holder.tvRxJuli.setText(list.get(position).getDistance()+"km");
        final FindCinemesBean.ResultBean.NearbyCinemaListBean bean = list.get(position);

        final boolean[] followCinema = {bean.isFollowCinema()};
        holder.ivRxGuanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v==holder.ivRxGuanzhu) {
                    if (followCinema[0]) {

                        holder.ivRxGuanzhu.setImageResource(R.drawable.guanzhu);
                    }else {
                        holder.ivRxGuanzhu.setImageResource(R.drawable.guanzhu1);
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

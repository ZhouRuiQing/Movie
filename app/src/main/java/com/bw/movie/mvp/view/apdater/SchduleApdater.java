package com.bw.movie.mvp.view.apdater;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.ScheduleBean;
import com.bw.movie.mvp.view.activity.BuyTicketActivity;

import java.util.List;

/**
 * 作者：轻 on 2018/11/14 16:50
 * <p>
 * 邮箱：379996854@qq.com
 */
public class SchduleApdater extends RecyclerView.Adapter<SchduleViewHoder> {
    Context context;
    List<ScheduleBean.ResultBean> list;
    double fare;

    public SchduleApdater(Context context, List<ScheduleBean.ResultBean> list, double fare) {
        this.context = context;
        this.list = list;
        this.fare=fare;
    }

    @NonNull
    @Override
    public SchduleViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        SchduleViewHoder hoder = new SchduleViewHoder(LayoutInflater.from(context).inflate(R.layout.schdule_item,parent,false));
        return hoder;
    }
    @Override
    public void onBindViewHolder(@NonNull SchduleViewHoder holder, final int position) {

        holder.tvSchduleName.setText(list.get(position).getScreeningHall());
        holder.tvSchduleBegin.setText(list.get(position).getBeginTime()+"——"+list.get(position).getEndTime());
//        holder.tvSchduleEnd.setText();
        holder.tvSchdulePrice.setText(fare+"");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,BuyTicketActivity.class);
                intent.putExtra("paiid",list.get(position).getId());
                intent.putExtra("fare",fare);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

package com.bw.movie.mvp.view.apdater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.ScheduleBean;

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
    public void onBindViewHolder(@NonNull SchduleViewHoder holder, int position) {

        holder.tvSchduleName.setText(list.get(position).getScreeningHall());
        holder.tvSchduleBegin.setText(list.get(position).getBeginTime()+"——");
        holder.tvSchduleEnd.setText(list.get(position).getEndTime());
        holder.tvSchdulePrice.setText(fare+"");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //context.startActivity(new Intent(this,BuyTicketActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

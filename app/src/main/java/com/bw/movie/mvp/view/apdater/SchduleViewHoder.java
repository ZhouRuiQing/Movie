package com.bw.movie.mvp.view.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bw.movie.R;

/**
 * 作者：轻 on 2018/11/14 16:50
 * <p>
 * 邮箱：379996854@qq.com
 */
class SchduleViewHoder extends RecyclerView.ViewHolder {

    public TextView tvSchdulePrice;
    public TextView textView2;
    public TextView tvSchduleName;
    public TextView tvSchduleBegin;
    public TextView tvSchduleEnd;


    public SchduleViewHoder(View itemView) {
        super(itemView);


        textView2 = itemView.findViewById(R.id.tv_schdule_ch);
        tvSchduleName =itemView.findViewById(R.id.tv_schdule_name);
        tvSchduleBegin =itemView.findViewById(R.id.tv_schdule_begin);
        tvSchduleEnd = itemView.findViewById(R.id.tv_schdule_end);
        tvSchdulePrice = itemView.findViewById(R.id.tv_schdule_price);

    }
}

package com.bw.movie.mvp.view.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bw.movie.R;

import cn.jzvd.JzvdStd;


class MyForseViewHoder extends RecyclerView.ViewHolder {

    public ImageView play_image;
    public JzvdStd jzvdStd;
    public MyForseViewHoder(View itemView) {
        super(itemView);
        jzvdStd = itemView.findViewById(R.id.jzbfq);
        play_image = itemView.findViewById(R.id.play_list_image);
    }
}

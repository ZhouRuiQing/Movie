package com.bw.movie.mvp.view.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bw.movie.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerSimple;

class MyForseViewHoder extends RecyclerView.ViewHolder {

    public ImageView play_image;
    public JCVideoPlayerSimple play_list_viedeo;

    public MyForseViewHoder(View itemView) {
        super(itemView);
        play_list_viedeo = itemView.findViewById(R.id.play_list_video);
        play_image = itemView.findViewById(R.id.play_list_image);
    }
}

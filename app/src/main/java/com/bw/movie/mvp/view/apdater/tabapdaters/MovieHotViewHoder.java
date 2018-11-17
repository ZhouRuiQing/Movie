package com.bw.movie.mvp.view.apdater.tabapdaters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;

class MovieHotViewHoder extends RecyclerView.ViewHolder {
    public ImageView hot_btn_heart;
    public ImageView ivMovieImage;
    public TextView tvTitle;
    public TextView tvname;


    public MovieHotViewHoder(View itemView) {
        super(itemView);

        ivMovieImage = itemView.findViewById(R.id.iv_movie_image);
        tvTitle = itemView.findViewById(R.id.tv_title);
        tvname = itemView.findViewById(R.id.tv_name);
        hot_btn_heart = itemView.findViewById(R.id.hot_btn_heart);

    }
}

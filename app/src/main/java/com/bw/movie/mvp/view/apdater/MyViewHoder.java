package com.bw.movie.mvp.view.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bw.movie.R;

class MyViewHoder extends RecyclerView.ViewHolder {
    public ImageView ivMovieImageItem;



    public MyViewHoder(View itemView) {
        super(itemView);
        ivMovieImageItem = itemView.findViewById(R.id.iv_movie_image_item);
    }
}

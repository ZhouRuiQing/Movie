package com.bw.movie.mvp.view.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;

class MovieHotViewHoder extends RecyclerView.ViewHolder {

    public ImageView ivMovieImage;


    public MovieHotViewHoder(View itemView) {
        super(itemView);

        ivMovieImage = itemView.findViewById(R.id.iv_movie_image);


    }
}

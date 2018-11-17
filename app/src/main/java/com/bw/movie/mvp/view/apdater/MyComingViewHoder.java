package com.bw.movie.mvp.view.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;

class MyComingViewHoder extends RecyclerView.ViewHolder {

    public ImageView ivMovieImageThree;



    public MyComingViewHoder(View itemView) {
        super(itemView);


        ivMovieImageThree = itemView. findViewById(R.id.iv_movie_image_three);

    }
}

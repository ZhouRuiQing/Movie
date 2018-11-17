package com.bw.movie.mvp.view.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;

class MyFindViewHoder extends RecyclerView.ViewHolder {

    public ImageView ivMovieImageTwo;

    public MyFindViewHoder(View itemView) {
        super(itemView);

        ivMovieImageTwo = itemView. findViewById(R.id.iv_movie_image_two);


    }
}

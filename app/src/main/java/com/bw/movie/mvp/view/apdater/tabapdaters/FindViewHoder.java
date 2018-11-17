package com.bw.movie.mvp.view.apdater.tabapdaters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;

class FindViewHoder extends RecyclerView.ViewHolder {

    public ImageView find_iv_heard;
    public ImageView ivFindImage;
    public TextView tvNameTwo;
    public TextView tvTitleTwo;


    public FindViewHoder(View itemView) {
        super(itemView);

        ivFindImage = itemView. findViewById(R.id.iv_find_image);
        tvNameTwo = itemView. findViewById(R.id.tv_name_two);
        tvTitleTwo = itemView. findViewById(R.id.tv_title_two);
        find_iv_heard = itemView.findViewById(R.id.find_btn_heart);


    }
}

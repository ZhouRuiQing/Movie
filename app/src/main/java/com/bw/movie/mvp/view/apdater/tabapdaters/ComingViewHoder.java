package com.bw.movie.mvp.view.apdater.tabapdaters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;

class ComingViewHoder extends RecyclerView.ViewHolder {

    public ImageView coming_heard;
    public ImageView ivFindImage;
    public TextView tvNameTwo;
    public TextView tvTitleTwo;


    public ComingViewHoder(View itemView) {
        super(itemView);

        ivFindImage = itemView.findViewById(R.id.iv_Coming_image);
        tvNameTwo = itemView. findViewById(R.id.tv_name_three);
        tvTitleTwo = itemView. findViewById(R.id.tv_title_three);
        coming_heard = itemView.findViewById(R.id.coming_btn_heart);


    }
}

package com.bw.movie.mvp.view.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;

/**
 * 作者：轻 on 2018/11/9 19:05
 * <p>
 * 邮箱：379996854@qq.com
 */
class NearViewHodeer extends RecyclerView.ViewHolder {

    public ImageView ivNearImage;
    public TextView tvNearName;
    public TextView tvNaerTitle;
    public TextView tvNearJuli;
    public ImageView ivNearGuanzhu;


    public NearViewHodeer(View itemView) {
        super(itemView);


        ivNearImage = itemView.findViewById(R.id.iv_near_image);
        tvNearName = itemView.findViewById(R.id.tv_near_name);
        tvNaerTitle = itemView.findViewById(R.id.tv_naer_title);
        tvNearJuli = itemView.findViewById(R.id.tv_near_juli);
        ivNearGuanzhu = itemView.findViewById(R.id.iv_near_guanzhu);


    }
}

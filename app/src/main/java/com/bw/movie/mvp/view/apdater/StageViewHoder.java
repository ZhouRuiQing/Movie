package com.bw.movie.mvp.view.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bw.movie.R;

class StageViewHoder extends RecyclerView.ViewHolder {

    public ImageView iv_stage_image;

    public StageViewHoder(View itemView) {
        super(itemView);

        iv_stage_image = itemView.findViewById(R.id.iv_stage_image);
    }
}

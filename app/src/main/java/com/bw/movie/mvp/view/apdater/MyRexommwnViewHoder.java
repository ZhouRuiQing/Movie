package com.bw.movie.mvp.view.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;

class MyRexommwnViewHoder extends RecyclerView.ViewHolder {

    public ImageView ivRxImage;
    public TextView tvReName;
    public TextView tvRxTitle;
    public TextView tvRxJuli;
    public ImageView ivRxGuanzhu;




    public MyRexommwnViewHoder(View itemView) {
        super(itemView);

        ivRxImage = itemView.findViewById(R.id.iv_rx_image);
        tvReName = itemView. findViewById(R.id.tv_re_name);
        tvRxTitle = itemView.findViewById(R.id.tv_rx_title);
        tvRxJuli = itemView. findViewById(R.id.tv_rx_juli);
        ivRxGuanzhu = itemView. findViewById(R.id.iv_rx_guanzhu);
    }
}

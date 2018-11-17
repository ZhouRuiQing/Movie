package com.bw.movie.mvp.view.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;



public class CommentViewHolder extends RecyclerView.ViewHolder {
    public final TextView title_one, price_one,sijian,shu_s;
    public final SimpleDraweeView image_view;

    public CommentViewHolder(View itemView) {
        super(itemView);
        image_view = itemView.findViewById(R.id.simple_drawee_view);
        title_one = itemView.findViewById(R.id.name_s);
        price_one = itemView.findViewById(R.id.shuju_s);
        sijian = itemView.findViewById(R.id.riqi_s);
        shu_s = itemView.findViewById(R.id.shu_s);
    }
    public void bindtext(String img, String desc, String desc2, String time , String s) {
        image_view.setImageURI(img);
        title_one.setText(desc);
        price_one.setText(desc2);
        sijian.setText(time);
        shu_s.setText(s);
    }
}

package com.bw.movie.mvp.view.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * 作者：轻 on 2018/11/10 14:55
 * <p>
 * 邮箱：379996854@qq.com
 */
class FilmViewHoder  extends RecyclerView.ViewHolder {

    public SimpleDraweeView ivFilmImage;
    public TextView filmName;
    public TextView filmTitle;



    public FilmViewHoder(View itemView) {
        super(itemView);

        ivFilmImage = itemView.findViewById(R.id.iv_film_image);
        filmName = itemView.findViewById(R.id.film_name);
        filmTitle = itemView.findViewById(R.id.film_title);

    }
}

package com.bw.movie.mvp.view.apdater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.FilmBean;

import java.util.List;

/**
 * 作者：轻 on 2018/11/10 14:54
 * <p>
 * 邮箱：379996854@qq.com
 */
public class FilmApdater extends RecyclerView.Adapter<FilmViewHoder> {

    Context context;
    List<FilmBean.ResultBean> list;


    public FilmApdater(Context context, List<FilmBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FilmViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        FilmViewHoder hoder =new FilmViewHoder(LayoutInflater.from(context).inflate(R.layout.film_item,parent,false));
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHoder holder, int position) {

        holder.ivFilmImage.setImageURI(list.get(position).getCommentHeadPic());
        holder.filmName.setText(list.get(position).getCommentUserName());
        holder.filmTitle.setText(list.get(position).getCommentContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

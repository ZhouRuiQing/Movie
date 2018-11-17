package com.bw.movie.mvp.view.apdater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.DetailMovie;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerSimple;

public class MyForseApdater extends RecyclerView.Adapter<MyForseViewHoder> {
    Context context;
    List<DetailMovie.ResultBean.ShortFilmListBean> list;

    public MyForseApdater(Context context, List<DetailMovie.ResultBean.ShortFilmListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyForseViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyForseViewHoder hoder = new MyForseViewHoder(LayoutInflater.from(context).inflate(R.layout.fores_item,null));
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyForseViewHoder holder, int position) {

        boolean setUp = holder.play_list_viedeo.setUp(list.get(position).getVideoUrl(), JCVideoPlayerSimple.SCREEN_LAYOUT_LIST);

        if(setUp){

            Glide.with(context).load(list.get(position).getImageUrl()).into(holder.play_image);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

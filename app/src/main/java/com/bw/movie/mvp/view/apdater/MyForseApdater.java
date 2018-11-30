package com.bw.movie.mvp.view.apdater;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.DetailMovie;

import java.util.List;

import cn.jzvd.JzvdStd;


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

       // holder.play_list_viedeo.setUp(list.get(position).getVideoUrl(),JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL);
        holder.jzvdStd.setUp(list.get(position).getVideoUrl(),null, JzvdStd.CURRENT_STATE_NORMAL);
        //设置全屏播放
        JzvdStd.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;  //横向
        JzvdStd.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT;  //纵向
        //将缩略图的scaleType设置为FIT_XY（图片全屏）
        holder.jzvdStd.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        //设置容器内播放器高,解决黑边（视频全屏）
        JzvdStd.setVideoImageDisplayType(JzvdStd.VIDEO_IMAGE_DISPLAY_TYPE_FILL_PARENT);

        Log.i("onBindViewHolder", "onBindViewHolder: =====+"+list.get(position).getVideoUrl());
        Glide.with(context).load(list.get(position).getImageUrl()).into(holder.play_image);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}

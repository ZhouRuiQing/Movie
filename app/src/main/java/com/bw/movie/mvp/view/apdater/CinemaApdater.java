package com.bw.movie.mvp.view.apdater;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.ByCinemaBean;
import com.bw.movie.mvp.model.utils.GlideRoundTransform;
import com.bw.movie.mvp.view.activity.ShowActivity;

import java.util.List;

/**
 * 作者：轻 on 2018/11/12 15:45
 * <p>
 * 邮箱：379996854@qq.com
 */
public class CinemaApdater extends RecyclerView.Adapter<MovieHotViewHoder> {
    Context context;
    List<ByCinemaBean.ResultBean> list;

    public CinemaApdater(Context context, List<ByCinemaBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MovieHotViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieHotViewHoder hoder = new MovieHotViewHoder(LayoutInflater.from(context).inflate(R.layout.movie_item,parent,false));
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHotViewHoder holder, final int position) {

        Glide.with(context).load(list.get(position % list.size()).getImageUrl())
                .bitmapTransform(new GlideRoundTransform(context, 35))
                .into(holder.ivMovieImage);

        //holder.ivMovieImage.setImageURI(Uri.parse(list.get(position).getImageUrl()));
       /* holder.tvTitle.setText(list.get(position).getSummary());
        holder.tvDis.setText(list.get(position).getRank()+"km");*/
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            /*   int id = list.get(position).getId();
                 EventBus.getDefault().postSticky(id);*/
                //Log.i("aaa",id+"id");
                Intent intent = new Intent(context, ShowActivity.class);
                intent.putExtra("id",list.get(position %list.size()).getId());
                context.startActivity(intent);
            }
        });

    }

    public interface RecyclerItemListener{
        void onClick(int position);
    }

    private RecyclerItemListener listener;

    public void setListener(RecyclerItemListener listener){
        this.listener = listener;
    }


    @Override
    public int getItemCount() {

        return list.size();
    }
}

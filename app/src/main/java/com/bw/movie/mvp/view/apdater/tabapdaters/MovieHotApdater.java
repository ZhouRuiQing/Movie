package com.bw.movie.mvp.view.apdater.tabapdaters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.Movieinfo;

import java.util.List;

public class MovieHotApdater extends RecyclerView.Adapter<MovieHotViewHoder> {
    Context context;
    List<Movieinfo.ResultBean> list;
    boolean guanzhu = false;


    public MovieHotApdater(Context context, List<Movieinfo.ResultBean> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public MovieHotViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieHotViewHoder hoder = new MovieHotViewHoder(LayoutInflater.from(context).inflate(R.layout.movie_hot_item,parent,false));
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieHotViewHoder holder, int position) {

        Glide.with(context).load(list.get(position).getImageUrl()).into(holder.ivMovieImage);
        //holder.ivMovieImage.setImageURI(Uri.parse(list.get(position).getImageUrl()));
        holder.tvTitle.setText(list.get(position).getSummary());
        holder.tvname.setText(list.get(position).getName()+"");

        holder.hot_btn_heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(v==holder.hot_btn_heart){
                    if(guanzhu){

                        holder.hot_btn_heart.setImageResource(R.drawable.guanzhu);
                    }else {

                        holder.hot_btn_heart.setImageResource(R.drawable.guanzhu1);
                    }
                    guanzhu=!guanzhu;
                }
            }
        });
    }

    @Override
    public int getItemCount() {

        return list.size();
    }
}

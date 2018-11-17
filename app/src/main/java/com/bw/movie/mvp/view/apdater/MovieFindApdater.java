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
import com.bw.movie.mvp.model.bean.MovieFindinfo;
import com.bw.movie.mvp.model.utils.GlideRoundTransform;
import com.bw.movie.mvp.view.activity.ShowActivity;

import java.util.List;

public class MovieFindApdater extends RecyclerView.Adapter<MyFindViewHoder> {
    Context context;
    List<MovieFindinfo.ResultBean> list;


    public MovieFindApdater(Context context, List<MovieFindinfo.ResultBean> list) {
        this.context = context;
        this.list = list;
    }



    @NonNull
    @Override
    public MyFindViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyFindViewHoder hoder = new MyFindViewHoder(LayoutInflater.from(context).inflate(R.layout.find_item,parent,false));
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyFindViewHoder holder, final int position) {


        Glide.with(context)
                .load(list.get(position).getImageUrl())
                .bitmapTransform(new GlideRoundTransform(context, 35))
                .into(holder.ivMovieImageTwo);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,ShowActivity.class);
                intent.putExtra("id",list.get(position).getId());
                context.startActivity(intent);
            }
        });

        //Uri parse = Uri.parse(list.get(position % list.size()).getImageUrl());
        //holder.ivMovieImageTwo.setImageURI(parse);
       /* holder.tvTitleTwo.setText(list.get(position).getSummary());
        holder.tvDisTwo.setText(list.get(position).getRank()+"km");*/
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

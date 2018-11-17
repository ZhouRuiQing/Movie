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
import com.bw.movie.mvp.model.bean.Movieinfo;
import com.bw.movie.mvp.model.utils.GlideRoundTransform;
import com.bw.movie.mvp.view.activity.ShowActivity;

import java.util.List;

public class MyApdater extends RecyclerView.Adapter<MyViewHoder> {
    Context context;
    List<Movieinfo.ResultBean> list;

    public MyApdater(Context context, List<Movieinfo.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHoder hoder = new MyViewHoder(LayoutInflater.from(context).inflate(R.layout.item,parent,false));
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoder holder, final int position) {


        Glide.with(context).load(list.get(position).getImageUrl())
                .bitmapTransform(new GlideRoundTransform(context, 35))
                .into(holder.ivMovieImageItem);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            /*   int id = list.get(position).getId();
               EventBus.getDefault().postSticky(id);*/
                //Log.i("aaa",id+"id");
                Intent intent = new Intent(context, ShowActivity.class);
                intent.putExtra("id",list.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

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
import com.bw.movie.mvp.model.bean.ComingMovie;
import com.bw.movie.mvp.model.utils.GlideRoundTransform;
import com.bw.movie.mvp.view.activity.ShowActivity;

import java.util.List;

public class ComingApdater extends RecyclerView.Adapter<MyComingViewHoder> {
    Context context;
    List<ComingMovie.ResultBean> list;

    public ComingApdater(Context context, List<ComingMovie.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyComingViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyComingViewHoder hoder = new MyComingViewHoder(LayoutInflater.from(context).inflate(R.layout.coming_item,parent,false));

        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyComingViewHoder holder, final int position) {

        Glide.with(context)
                .load(list.get(position).getImageUrl())
                .bitmapTransform(new GlideRoundTransform(context,35))
                .into(holder.ivMovieImageThree);
        //holder.ivMovieImageThree.setImageURI(Uri.parse(list.get(position).getImageUrl()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ShowActivity.class);
                intent.putExtra("id",list.get(position %list.size()).getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

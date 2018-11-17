package com.bw.movie.mvp.view.apdater.tabapdaters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.ComingMovie;

import java.util.List;

public class ThreeComingApdater extends RecyclerView.Adapter<ComingViewHoder> {
    Context context;
    List<ComingMovie.ResultBean> list;
    private boolean guanzhu=false;

    public ThreeComingApdater(Context context, List<ComingMovie.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ComingViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ComingViewHoder hoder = new ComingViewHoder(LayoutInflater.from(context).inflate(R.layout.three_coming_item,parent,false));
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ComingViewHoder holder, int position) {

        Glide.with(context).load(list.get(position).getImageUrl()).into(holder.ivFindImage);
        //holder.ivFindImage.setImageURI(Uri.parse(list.get(position).getImageUrl()));
        holder.tvTitleTwo.setText(list.get(position).getSummary());
        holder.tvNameTwo.setText(list.get(position).getName()+"");


        holder.coming_heard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(v==holder.coming_heard){
                    if(guanzhu){

                        holder.coming_heard.setImageResource(R.drawable.guanzhu);
                    }else {

                        holder.coming_heard.setImageResource(R.drawable.guanzhu1);
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

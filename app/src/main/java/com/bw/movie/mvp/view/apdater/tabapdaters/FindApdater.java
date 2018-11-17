package com.bw.movie.mvp.view.apdater.tabapdaters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.MovieFindinfo;

import java.util.List;

public class FindApdater extends RecyclerView.Adapter<FindViewHoder> {
    Context context;
    List<MovieFindinfo.ResultBean> list;
    private boolean guanzhu=false;

    public FindApdater(Context context, List<MovieFindinfo.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FindViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FindViewHoder hoder = new FindViewHoder(LayoutInflater.from(context).inflate(R.layout.two_find_item,parent,false));
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull final FindViewHoder holder, int position) {

        Glide.with(context).load(list.get(position).getImageUrl()).into(holder.ivFindImage);
        //holder.ivFindImage.setImageURI(Uri.parse(list.get(position).getImageUrl()));
        holder.tvTitleTwo.setText(list.get(position).getSummary());
        holder.tvNameTwo.setText(list.get(position).getName()+"");

        holder.find_iv_heard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(v==holder.find_iv_heard){
                    if(guanzhu){

                        holder.find_iv_heard.setImageResource(R.drawable.guanzhu);
                    }else {

                        holder.find_iv_heard.setImageResource(R.drawable.guanzhu1);
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

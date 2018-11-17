package com.bw.movie.mvp.view.apdater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bw.movie.R;

import java.util.List;

public class MyStageApdater extends RecyclerView.Adapter<StageViewHoder> {
    Context context;
    List<String>  list;

    public MyStageApdater(Context context, List<String>  bean) {

        this.list=bean;
        this.context=context;
    }



    @NonNull
    @Override
    public StageViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        StageViewHoder hoder = new StageViewHoder(LayoutInflater.from(context).inflate(R.layout.stage_item, parent, false));
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull StageViewHoder holder, int position) {

        Glide.with(context).load(list.get(position).split("\\|")[0])
                .into(holder.iv_stage_image);
        //holder.iv_stage_image.setImageURI(list.get(position));
        Log.i("aaa",list.get(position)+"".split("\\|")[0]+"name");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

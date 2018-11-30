package com.bw.movie.mvp.view.apdater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.AttenMovieBean;
import com.bw.movie.mvp.view.apdater.tabapdaters.FindViewHoder;

import java.util.List;

/**
 * 作者：轻 on 2018/11/21 09:47
 * <p>
 * 邮箱：379996854@qq.com
 */
public class AtrenMovieApdater extends RecyclerView.Adapter<FindViewHoder> {
    Context context;
    List<AttenMovieBean.ResultBean> list;

    public AtrenMovieApdater(Context context, List<AttenMovieBean.ResultBean> list) {
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
    public void onBindViewHolder(@NonNull FindViewHoder holder, int position) {

        Glide.with(context).load(list.get(position).getImageUrl()).into(holder.ivFindImage);
        //holder.ivFindImage.setImageURI(Uri.parse(list.get(position).getImageUrl()));
        //AttenMovieBean.ResultBean bean = list.get(position);
        holder.tvTitleTwo.setText(list.get(position).getSummary());
        holder.tvNameTwo.setText(list.get(position).getName()+"");
        holder.find_iv_heard.setImageResource(R.drawable.guanzhu1);
    }

    @Override
    public int getItemCount() {


        return list.size();
    }
}

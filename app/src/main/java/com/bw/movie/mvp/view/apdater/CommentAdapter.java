package com.bw.movie.mvp.view.apdater;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.CommentBean;

import java.text.SimpleDateFormat;
import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentViewHolder> {
    Context context;
    List<CommentBean.ResultBean> list;

    public CommentAdapter(Context context, List<CommentBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }


/*    private String s;


    public CommentAdapter(Context context) {
        this.context = context;
    }

    public void addData(List<CommentBean.ResultBean> list, boolean isFresh){
        if (list!=null) {
            if(isFresh) {
                this.list.clear();
            }
            this.list.addAll(list);
        }

    }*/
    public List<CommentBean.ResultBean> getData() {
        return list;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CommentViewHolder(LayoutInflater.from(context).inflate(R.layout.comment_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, final int position) {
        holder.image_view.setImageURI(list.get(position).getCommentHeadPic());
        holder.title_one.setText(list.get(position).getCommentUserName());
        holder.price_one.setText(list.get(position).getCommentContent());
        long commentTime = list.get(position).getCommentTime();
     //  holder.shu_s.setText(list.get(position).getIsGreat());
        /*String img= list.get(position).getCommentHeadPic();
        String desc=list.get(position).getCommentUserName();
        Log.i("vvvl",desc);
        String desc2=list.get(position).getCommentContent();
        long desc3=list.get(position).getCommentTime();*/

        SimpleDateFormat sdf =new SimpleDateFormat("HH:mm:ss");
        String time= sdf.format(commentTime);
        holder.sijian.setText(time);

        int desc4=list.get(position).getGreatNum();
        String s = String.valueOf(desc4);
        holder.shu_s.setText(s);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

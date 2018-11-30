package com.bw.movie.mvp.view.apdater;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.AttenBean;
import com.bw.movie.mvp.model.bean.AttenMovieBean;
import com.bw.movie.mvp.model.bean.FindCinemesBean;
import com.bw.movie.mvp.present.AttenCinemaPresent;
import com.bw.movie.mvp.present.UnAttenCinemaPresent;
import com.bw.movie.IView.IAttenCinemaView;
import com.bw.movie.IView.IUnAttenCinemaView;
import com.bw.movie.mvp.view.activity.CinemaInfoActivity;
import com.bw.movie.mvp.view.activity.ReginActivity;

import java.util.List;

public class RexommwndApdater extends RecyclerView.Adapter<MyRexommwnViewHoder> implements IAttenCinemaView,IUnAttenCinemaView {
    Context context;
    List<FindCinemesBean.ResultBean.NearbyCinemaListBean> list;
    private AttenCinemaPresent attenCinemaPresent;
    private UnAttenCinemaPresent unAttenCinemaPresent;
    private boolean guanzhu=false;
    private boolean followCinema=false;
    private SharedPreferences user;
    private boolean isLogin;

    public RexommwndApdater(Context context, List<FindCinemesBean.ResultBean.NearbyCinemaListBean> list) {
        this.context = context;
        this.list = list;
    }

    private void initView() {

        //关注
        attenCinemaPresent = new AttenCinemaPresent(this);

        //取消关注
        unAttenCinemaPresent = new UnAttenCinemaPresent(this);

    }

    @NonNull
    @Override
    public MyRexommwnViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyRexommwnViewHoder hoder = new MyRexommwnViewHoder(LayoutInflater.from(context).inflate(R.layout.rexommend_item,parent,false));
        initView();
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyRexommwnViewHoder holder, final int position) {

        Glide.with(context).load(list.get(position).getLogo()).into(holder.ivRxImage);
        holder.tvReName.setText(list.get(position).getName());
        holder.tvRxTitle.setText(list.get(position).getAddress());
        holder.tvRxJuli.setText(list.get(position).getDistance()+"km");
        final int id = list.get(position).getId();
        final FindCinemesBean.ResultBean.NearbyCinemaListBean bean = list.get(position);

        followCinema = bean.isFollowCinema();
        //final boolean[] followCinema = {bean.isFollowCinema()};
        user = context.getSharedPreferences("user", Context.MODE_PRIVATE);

        isLogin = user.getBoolean("isLogin", true);

        holder.ivRxGuanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v == holder.ivRxGuanzhu) {
                    if (isLogin) {

                        if (followCinema) {
                            holder.ivRxGuanzhu.setImageResource(R.drawable.guanzhu);
                            unAttenCinemaPresent.getUnAttenCinema(id);
                        } else {
                            holder.ivRxGuanzhu.setImageResource(R.drawable.guanzhu1);
                            attenCinemaPresent.getAttenCinema(id);
                        }
                        followCinema = !followCinema;
                    }else {
                        Toast.makeText(context, "先登录", Toast.LENGTH_SHORT).show();
                        context.startActivity(new Intent(context,ReginActivity.class));
                    }
                }
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CinemaInfoActivity.class);
                intent.putExtra("id",list.get(position).getId());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    //关注
    @Override
    public void success(AttenBean attenBean) {

        Log.i("success", "success: ======"+attenBean.getMessage());
    }

    //取消关注
    @Override
    public void success(AttenMovieBean attenMovieBean) {
        Log.i("success", "success: ======"+attenMovieBean.getMessage());
    }

    @Override
    public void Error(String msg) {

    }
}

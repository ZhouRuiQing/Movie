package com.bw.movie.mvp.view.apdater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.mvp.model.bean.UserBuyTicketBean;

import java.util.List;

/**
 * 作者：轻 on 2018/11/23 20:30
 * <p>
 * 邮箱：379996854@qq.com
 */
public class ShopApdater extends RecyclerView.Adapter<ShopViewHoder> {
    List<UserBuyTicketBean.ResultBean> list;
    Context context;

    public ShopApdater(List<UserBuyTicketBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ShopViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ShopViewHoder hoder = new ShopViewHoder(LayoutInflater.from(context).inflate(R.layout.shop_item, parent, false));
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHoder holder, int position) {

        if (list.get(position).getStatus() == 1) {

            holder.tv_shop_payment.setText("待付款");
            holder.tvShopName.setText(list.get(position).getMovieName());
            Log.i("message", "onBindViewHolder: ======" + list.get(position).getMovieName());
            holder.tvShopOrder.setText("订单号 :" + list.get(position).getOrderId());
            holder.tvShopCinema.setText("影院 :" + list.get(position).getCinemaName());
            holder.tvShopMovieHall.setText("影厅 :" + list.get(position).getScreeningHall());
            String beginTime = list.get(position).getBeginTime();
            String endTime = list.get(position).getEndTime();
//
//            Date date = new Date(beginTime);
//            Date data = new Date(endTime);
//            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm —— hh:mm");
//            SimpleDateFormat sb = new SimpleDateFormat("yyyy-MM-dd hh:mm —— hh:mm");
//            String databegin = sd.format(date);
//            String dataend = sb.format(data);
            holder.tvShopTime.setText("时间 :" + beginTime + "---" + endTime);
            holder.tvShopNum.setText("数量 :" + list.get(position).getAmount());
            holder.tvShopPrice.setText("价钱" + list.get(position).getPrice());
        } else if (list.get(position).getStatus() == 2) {

            holder.tvShopName.setText(list.get(position).getMovieName());
            Log.i("message", "onBindViewHolder: ======" + list.get(position).getMovieName());
            holder.tvShopOrder.setText("订单号" + list.get(position).getOrderId());
            holder.tvShopCinema.setText("影院" + list.get(position).getCinemaName());
            holder.tvShopMovieHall.setText("影厅" + list.get(position).getScreeningHall());
            String beginTime = list.get(position).getBeginTime();
            String endTime = list.get(position).getEndTime();

            holder.tvShopTime.setText("时间 :" + beginTime + "---" + endTime);
            holder.tvShopNum.setText("数量 :" + list.get(position).getAmount());
            holder.tvShopPrice.setText("价钱" + list.get(position).getPrice());
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

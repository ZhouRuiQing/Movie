package com.bw.movie.mvp.view.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bw.movie.R;

/**
 * 作者：轻 on 2018/11/23 20:30
 * <p>
 * 邮箱：379996854@qq.com
 */
class ShopViewHoder extends RecyclerView.ViewHolder {

    public TextView tv_shop_payment;
    public TextView tvShopName;
    public TextView tvShopOrder;
    public TextView tvShopCinema;
    public TextView tvShopMovieHall;
    public TextView tvShopTime;
    public TextView tvShopNum;
    public TextView tvShopPrice;


    public ShopViewHoder(View itemView) {
        super(itemView);


        tvShopName = itemView.findViewById(R.id.tv_shop_name);
        tvShopOrder = itemView.findViewById(R.id.tv_shop_order);
        tvShopCinema = itemView.findViewById(R.id.tv_shop_cinema);
        tvShopMovieHall = itemView.findViewById(R.id.tv_shop_movie_hall);
        tvShopTime = itemView.findViewById(R.id.tv_shop_time);
        tvShopNum = itemView.findViewById(R.id.tv_shop_num);
        tvShopPrice = itemView.findViewById(R.id.tv_shop_price);
        tv_shop_payment = itemView.findViewById(R.id.tv_shop_payment);
    }
}

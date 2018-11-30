package com.bw.movie.mvp.model;

import com.bw.movie.mvp.model.bean.IndentBean;
import com.bw.movie.mvp.model.bean.PayBean;
import com.bw.movie.mvp.model.utils.HttpUtils;

import io.reactivex.Observable;

/**
 * 作者：轻 on 2018/11/22 14:34
 * <p>
 * 邮箱：379996854@qq.com
 */
public class ModelPay {

    //微信支付
    public   Observable<PayBean>  getPay(int payType,String orderId){

       return HttpUtils.getInstance().api.getPay(payType, orderId);
    }

    //购票下单

    public Observable<IndentBean> getShopOrder(int scheduleId,int amount,String sign){

         return HttpUtils.getInstance().api.getShopOrder(scheduleId, amount, sign);
    }
}

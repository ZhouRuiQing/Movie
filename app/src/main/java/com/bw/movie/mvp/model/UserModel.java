package com.bw.movie.mvp.model;

import com.bw.movie.mvp.model.bean.RegBean;
import com.bw.movie.mvp.model.bean.UserBean;
import com.bw.movie.mvp.model.bean.UserBuyBean;
import com.bw.movie.mvp.model.utils.HttpUtils;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * 作者：轻 on 2018/11/14 10:58
 * <p>
 * 邮箱：379996854@qq.com
 */
public class UserModel {

    //注册
    public Observable<UserBean> getUser(HashMap<String, String> map){

         return HttpUtils.getInstance().api.getUser(map);
    }

    //登录
    public Observable<RegBean> getReg(HashMap<String, String> map){

        return HttpUtils.getInstance().api.getReg(map);
    }

    //用户购票记录查询列表
    public Observable<UserBuyBean> getUserBuy(int page,int count){

        return HttpUtils.getInstance().api.getUserBuy(page,count);
    }
}

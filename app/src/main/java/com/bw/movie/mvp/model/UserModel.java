package com.bw.movie.mvp.model;

import com.bw.movie.mvp.model.bean.AttenMovieBean;
import com.bw.movie.mvp.model.bean.ChageTouBean;
import com.bw.movie.mvp.model.bean.FeedBackBean;
import com.bw.movie.mvp.model.bean.RegBean;
import com.bw.movie.mvp.model.bean.UserBean;
import com.bw.movie.mvp.model.bean.UserBuyTicketBean;
import com.bw.movie.mvp.model.bean.WeEBean;
import com.bw.movie.mvp.model.utils.HttpUtils;

import java.io.File;
import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

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

//    //用户购票记录查询列表
//    public Observable<UserBuyTicketBean> getUserBuy(int page,int count){
//
//        return HttpUtils.getInstance().api.getUserBuyTicket(page,count);
//    }

    //上传头像
    public   Observable<ChageTouBean>  getChageTou(File file){

                MultipartBody.Part filePart = MultipartBody.Part.createFormData("image", file.getName(),
                RequestBody.create(MediaType.parse("image/*"), file));
        return HttpUtils.getInstance().api.getChageTou(filePart);
    }

    //我的关注

    public Observable<AttenMovieBean> getAttenMovie(int page,int count){

        return HttpUtils.getInstance().api.getAttenMovie(page,count);
    }

    //微信登录
    public Observable<WeEBean>  getWeiE(String code){

        return HttpUtils.getInstance().api.getWeiE(code);
    }

    //用户购票记录
    public   Observable<UserBuyTicketBean> getUserBuyTicket(int page,int count){

       return HttpUtils.getInstance().api.getUserBuyTicket(page,count);
    }

    //意见反馈
    public  Observable<FeedBackBean> getfeedback(String content){

       return HttpUtils.getInstance().api.getfeedback(content);
    }

}

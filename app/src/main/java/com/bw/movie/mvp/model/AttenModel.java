package com.bw.movie.mvp.model;

import com.bw.movie.mvp.model.bean.AttenBean;
import com.bw.movie.mvp.model.bean.UnflowwBean;
import com.bw.movie.mvp.model.utils.HttpUtils;

import io.reactivex.Observable;

/**
 * 作者：轻 on 2018/11/17 16:03
 * <p>
 * 邮箱：379996854@qq.com
 */
public class AttenModel  {

    //关注电影

    public  Observable<AttenBean>  getAtten(int movieId){

       return HttpUtils.getInstance().api.getAtten(movieId);
    }


    //取消关注
    public  Observable<UnflowwBean> getUnfloww(int movieId){

        return HttpUtils.getInstance().api.getUnfloww(movieId);
    }
}

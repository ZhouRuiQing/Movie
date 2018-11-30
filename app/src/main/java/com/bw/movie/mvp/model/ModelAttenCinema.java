package com.bw.movie.mvp.model;

import com.bw.movie.mvp.model.bean.AttenBean;
import com.bw.movie.mvp.model.bean.AttenCinemaBean;
import com.bw.movie.mvp.model.bean.AttenMovieBean;
import com.bw.movie.mvp.model.utils.HttpUtils;

import io.reactivex.Observable;

/**
 * 作者：轻 on 2018/11/21 10:28
 * <p>
 * 邮箱：379996854@qq.com
 */
public class ModelAttenCinema {

    //关注影院
    public   Observable<AttenBean>  getAttenCinema(int cinemaId){

       return HttpUtils.getInstance().api.getAttenCinema(cinemaId);
    }

    //取消关注影院
    public   Observable<AttenMovieBean>  getUnAttenCinema(int cinemaId){

        return HttpUtils.getInstance().api.getUnAttenCinema(cinemaId);
    }

    //我的关注影院
    public Observable<AttenCinemaBean>  getCinemaAtten(int page,int count){

        return HttpUtils.getInstance().api.getCinemaAtten(page,count);
    }
}

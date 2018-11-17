package com.bw.movie.mvp.model;

import com.bw.movie.mvp.model.bean.DetailMovie;
import com.bw.movie.mvp.model.utils.HttpUtils;

import io.reactivex.Observable;

public class DetaModel {

    public  Observable<DetailMovie>  getDetaMovie(int movieid){

       return HttpUtils.getInstance().api.getDetail(movieid);
    }
}

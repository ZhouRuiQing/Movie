package com.bw.movie.mvp.model;


import com.bw.movie.mvp.model.bean.Movieinfo;
import com.bw.movie.mvp.model.utils.HttpUtils;

import io.reactivex.Observable;

public class ModelMovie {

    public Observable<Movieinfo> getHotMovie(int page, int count){

       return HttpUtils.getInstance().api.getHotMovie(page,count);
    }
}

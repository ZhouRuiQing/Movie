package com.bw.movie.mvp.model;

import com.bw.movie.mvp.model.bean.MovieFindinfo;
import com.bw.movie.mvp.model.utils.HttpUtils;
import io.reactivex.Observable;

public class ModelFind {

    public  Observable<MovieFindinfo>  getFindMovie(int page, int count){

        return HttpUtils.getInstance().api.getFindMovie(page, count);

    }
}

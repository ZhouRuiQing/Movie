package com.bw.movie.mvp.model;

import com.bw.movie.mvp.model.bean.ComingMovie;
import com.bw.movie.mvp.model.utils.HttpUtils;
import io.reactivex.Observable;

public class ModelComing {

    public   Observable<ComingMovie> getComingMovie(int page, int count){

       return HttpUtils.getInstance().api.getComingMovie(page, count);
    }
}

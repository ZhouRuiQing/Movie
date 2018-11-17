package com.bw.movie.mvp.model;

import com.bw.movie.mvp.model.bean.FilmBean;
import com.bw.movie.mvp.model.utils.HttpUtils;

import io.reactivex.Observable;

/**
 * 作者：轻 on 2018/11/9 13:39
 * <p>
 * 邮箱：379996854@qq.com
 */
public class ModelFilm {

    public  Observable<FilmBean>  getFilm(int movieId,int page,int count){


      return HttpUtils.getInstance().api.getFlim(movieId, page, count);
    }
}

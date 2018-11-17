package com.bw.movie.mvp.model;

import com.bw.movie.mvp.model.bean.AllCinemasBean;
import com.bw.movie.mvp.model.utils.HttpUtils;

import io.reactivex.Observable;

/**
 * 作者：轻 on 2018/11/9 18:56
 * <p>
 * 邮箱：379996854@qq.com
 */
public class ModelAllCinemas {

    public  Observable<AllCinemasBean> getAllCinemas(int page,int count){

        return HttpUtils.getInstance().api.getAllCinemeas(page, count);
    }
}

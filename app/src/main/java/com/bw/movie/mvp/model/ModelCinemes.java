package com.bw.movie.mvp.model;

import com.bw.movie.mvp.model.bean.ByCinemaBean;
import com.bw.movie.mvp.model.bean.CinemaInfoBean;
import com.bw.movie.mvp.model.bean.CommentBean;
import com.bw.movie.mvp.model.bean.FindCinemesBean;
import com.bw.movie.mvp.model.bean.ScheduleBean;
import com.bw.movie.mvp.model.utils.HttpUtils;

import io.reactivex.Observable;

public class ModelCinemes {

    //推荐影院
    public Observable<FindCinemesBean> getCinemes(int page,int count){

         return HttpUtils.getInstance().api.getCinemes(page,count);
    }

    //影院详情
    public Observable<CinemaInfoBean> getCinemaInfo(int cinemaId){

         return HttpUtils.getInstance().api.getCinemaInfo(cinemaId);
    }

    //影院评论
    public Observable<CommentBean> getConmment(int cinemaId, int page, int count){

        return HttpUtils.getInstance().api.getComment(cinemaId,page,count);
    }

    //影院上映的时间
    public Observable<ScheduleBean> getSchedule(int cinemaId, int movieId){

        return HttpUtils.getInstance().api.getSchedule(cinemaId,movieId);
    }

    //根据影院ID查询该影院当前排期的电影列表
    public Observable<ByCinemaBean> getBycineam(int cinemaId){

        return HttpUtils.getInstance().api.getByCinemaId(cinemaId);
    }


}

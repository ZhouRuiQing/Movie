package com.bw.movie.mvp.present;

import com.bw.movie.mvp.model.ModelCinemes;
import com.bw.movie.mvp.model.bean.ScheduleBean;
import com.bw.movie.IView.IMovieSchedule;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：轻 on 2018/11/14 16:38
 * <p>
 * 邮箱：379996854@qq.com
 */
public class SchedulePresent extends BasePresent<IMovieSchedule>{

    ModelCinemes modelCinemes;
    IMovieSchedule iMovieSchedule;

    public SchedulePresent(IMovieSchedule iMovieSchedule){

        this.iMovieSchedule=iMovieSchedule;
        modelCinemes=new ModelCinemes();
    }

    public void  getAllCinemas(int cinemaId,int movieId){

        modelCinemes.getSchedule(cinemaId,movieId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ScheduleBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ScheduleBean scheduleBean) {

                        iMovieSchedule.success(scheduleBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

package com.bw.movie.mvp.present;

import com.bw.movie.mvp.model.ModelAttenCinema;
import com.bw.movie.mvp.model.bean.AttenMovieBean;
import com.bw.movie.IView.IUnAttenCinemaView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：轻 on 2018/11/21 10:40
 * <p>
 * 邮箱：379996854@qq.com
 */
public class UnAttenCinemaPresent extends BasePresent<IUnAttenCinemaView> {

    ModelAttenCinema modelAttenCinema;
    IUnAttenCinemaView iUnAttenCinemaView;

    public UnAttenCinemaPresent( IUnAttenCinemaView iUnAttenCinemaView){

        this.iUnAttenCinemaView=iUnAttenCinemaView;
        modelAttenCinema=new ModelAttenCinema();

    }

    public void getUnAttenCinema(int cinemaId){

        modelAttenCinema.getUnAttenCinema(cinemaId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AttenMovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AttenMovieBean attenMovieBean) {

                        iUnAttenCinemaView.success(attenMovieBean);
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

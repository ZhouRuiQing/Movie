package com.bw.movie.mvp.present;

import com.bw.movie.mvp.model.ModelAttenCinema;
import com.bw.movie.mvp.model.bean.AttenBean;
import com.bw.movie.IView.IAttenCinemaView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：轻 on 2018/11/21 10:33
 * <p>
 * 邮箱：379996854@qq.com
 */
public class AttenCinemaPresent extends BasePresent<IAttenCinemaView> {

    IAttenCinemaView iAttenCinemaView;
    ModelAttenCinema modelAttenCinema;


    public AttenCinemaPresent(IAttenCinemaView iAttenCinemaView){

        this.iAttenCinemaView=iAttenCinemaView;
        modelAttenCinema=new ModelAttenCinema();
    }

    public void getAttenCinema(int cinemaId){

        modelAttenCinema.getAttenCinema(cinemaId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AttenBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AttenBean attenBean) {

                        iAttenCinemaView.success(attenBean);
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

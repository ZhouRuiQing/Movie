package com.bw.movie.mvp.present;

import com.bw.movie.mvp.model.ModelAttenCinema;
import com.bw.movie.mvp.model.bean.AttenCinemaBean;
import com.bw.movie.IView.ICinemaAttenView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：轻 on 2018/11/21 11:31
 * <p>
 * 邮箱：379996854@qq.com
 */
public class CinemaAttenPresent extends BasePresent<ICinemaAttenView> {

    ICinemaAttenView iCinemaAttenView;
    ModelAttenCinema modelAttenCinema;

    public CinemaAttenPresent(ICinemaAttenView iCinemaAttenView){

        this.iCinemaAttenView=iCinemaAttenView;
        modelAttenCinema=new ModelAttenCinema();
    }

    public void  getCinemaAtten(int page,int count){

        modelAttenCinema.getCinemaAtten(page,count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AttenCinemaBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AttenCinemaBean attenCinemaBean) {

                        iCinemaAttenView.success(attenCinemaBean);
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

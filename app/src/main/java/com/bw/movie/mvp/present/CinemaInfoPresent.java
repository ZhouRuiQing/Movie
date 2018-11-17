package com.bw.movie.mvp.present;

import com.bw.movie.mvp.model.ModelCinemes;
import com.bw.movie.mvp.model.bean.CinemaInfoBean;
import com.bw.movie.mvp.view.IView.ICineminInfo;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：轻 on 2018/11/12 14:59
 * <p>
 * 邮箱：379996854@qq.com
 */
public class CinemaInfoPresent extends BasePresent<ICineminInfo> {

    ModelCinemes modelCinemes;
    ICineminInfo iCineminInfo;

    public  CinemaInfoPresent(ICineminInfo iCineminInfo){

        this.iCineminInfo=iCineminInfo;
        modelCinemes=new ModelCinemes();
    }

    public void getCinmeas(int cinemaId){

        modelCinemes.getCinemaInfo(cinemaId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<CinemaInfoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CinemaInfoBean cinemaInfoBean) {

                        iCineminInfo.success(cinemaInfoBean);
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

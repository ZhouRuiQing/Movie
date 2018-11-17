package com.bw.movie.mvp.present;

import com.bw.movie.mvp.model.bean.FindCinemesBean;
import com.bw.movie.mvp.model.ModelCinemes;
import com.bw.movie.mvp.view.IView.ICinemesView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CinemesPresent extends BasePresent<ICinemesView> {

    ICinemesView iCinemesView;
    ModelCinemes modelCinemes;

    public  CinemesPresent(ICinemesView iCinemesView){

        this.iCinemesView=iCinemesView;
        modelCinemes=new ModelCinemes();
    }

    public void  getCinemes(int page,int count){

        modelCinemes.getCinemes(page,count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<FindCinemesBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindCinemesBean cinemesBean) {

                        iCinemesView.success(cinemesBean);
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

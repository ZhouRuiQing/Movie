package com.bw.movie.mvp.present;

import com.bw.movie.mvp.model.ModelCinemes;
import com.bw.movie.mvp.model.bean.ByCinemaBean;
import com.bw.movie.mvp.view.IView.IByCinmeaView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：轻 on 2018/11/15 19:48
 * <p>
 * 邮箱：379996854@qq.com
 */
public class ByCinemaPresent extends BasePresent<IByCinmeaView> {

    IByCinmeaView iByCinmeaView;
    ModelCinemes modelCinemes;

    public  ByCinemaPresent(IByCinmeaView iByCinmeaView){

        this.iByCinmeaView=iByCinmeaView;
        modelCinemes=new ModelCinemes();
    }

    public void getBycinemas(int cinemaid){

        modelCinemes.getBycineam(cinemaid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ByCinemaBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ByCinemaBean byCinemaBean) {

                        iByCinmeaView.success(byCinemaBean);
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

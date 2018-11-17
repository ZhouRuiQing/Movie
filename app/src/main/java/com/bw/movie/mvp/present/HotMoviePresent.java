package com.bw.movie.mvp.present;

import android.util.Log;

import com.bw.movie.mvp.model.bean.Movieinfo;
import com.bw.movie.mvp.model.ModelMovie;
import com.bw.movie.mvp.view.IView.IHotMvoieView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HotMoviePresent extends BasePresent<IHotMvoieView> {

    ModelMovie modelMovie;
    IHotMvoieView iHotMvoieView;

    public HotMoviePresent(IHotMvoieView iHotMvoieView){

        this.iHotMvoieView=iHotMvoieView;
        modelMovie=new ModelMovie();
    }

    public void  getHoMovie(int page,int count){

        modelMovie.getHotMovie(page,count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Movieinfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Movieinfo movieinfo) {

                        iHotMvoieView.success(movieinfo);
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.i("xxx",e+"");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

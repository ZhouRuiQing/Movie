package com.bw.movie.mvp.present;

import android.util.Log;

import com.bw.movie.mvp.model.bean.MovieFindinfo;
import com.bw.movie.mvp.model.ModelFind;
import com.bw.movie.IView.IFindView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FindPresent extends BasePresent<IFindView> {

    IFindView iFindView;
    ModelFind modelFind;

    public FindPresent(IFindView iFindView){

        this.iFindView=iFindView;
        modelFind=new ModelFind();
    }

    public void  getFindMovie(int page,int count){

        modelFind.getFindMovie(page,count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MovieFindinfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(MovieFindinfo movieFindinfo) {

                        iFindView.success(movieFindinfo);
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.i("xxx",e+"'");
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}

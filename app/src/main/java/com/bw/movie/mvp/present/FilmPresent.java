package com.bw.movie.mvp.present;

import android.util.Log;

import com.bw.movie.mvp.model.bean.FilmBean;
import com.bw.movie.mvp.model.ModelFilm;
import com.bw.movie.mvp.view.IView.IFilmView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：轻 on 2018/11/9 13:41
 * <p>
 * 邮箱：379996854@qq.com
 */
public class FilmPresent extends BasePresent<IFilmView> {

    IFilmView filmView;
    ModelFilm modelFilm;

    public FilmPresent(IFilmView filmView){

        this.filmView=filmView;
        modelFilm=new ModelFilm();
    }

    public  void  getFilm(int movieId,int page,int count){

        modelFilm.getFilm(movieId,page,count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<FilmBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FilmBean filmBean) {

                        filmView.success(filmBean);
                        Log.i("aaa", "onNext: "+filmBean.getResult().size());
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.i("OnThrowable",e+"");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}

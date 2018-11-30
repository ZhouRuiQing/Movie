package com.bw.movie.mvp.present;

import com.bw.movie.mvp.model.UserModel;
import com.bw.movie.mvp.model.bean.AttenMovieBean;
import com.bw.movie.IView.IAttenMovieView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：轻 on 2018/11/21 09:27
 * <p>
 * 邮箱：379996854@qq.com
 */
public class AttrnMoviePresent extends BasePresent<IAttenMovieView> {

    IAttenMovieView iAttenMovieView;
    UserModel userModel;

    public AttrnMoviePresent(IAttenMovieView iAttenMovieView){

        this.iAttenMovieView=iAttenMovieView;
        userModel=new UserModel();
    }

    public void getAttenMovie(int page,int count){

        userModel.getAttenMovie(page,count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AttenMovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AttenMovieBean attenMovieBean) {

                        iAttenMovieView.success(attenMovieBean);
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

package com.bw.movie.mvp.present;

import android.util.Log;

import com.bw.movie.IView.IWeiEView;
import com.bw.movie.mvp.model.UserModel;
import com.bw.movie.mvp.model.bean.WeEBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：轻 on 2018/11/21 19:50
 * <p>
 * 邮箱：379996854@qq.com
 */
public class WeIePresent extends BasePresent<IWeiEView> {

    IWeiEView iWeiEView;
    UserModel userModel;

    public WeIePresent(IWeiEView iWeiEView){

        this.iWeiEView=iWeiEView;
         userModel=new UserModel();

    }

    public void  getWeiE(String code){

        userModel.getWeiE(code)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<WeEBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WeEBean weEBean) {

                        iWeiEView.success(weEBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.i("message", "onError: ======"+e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

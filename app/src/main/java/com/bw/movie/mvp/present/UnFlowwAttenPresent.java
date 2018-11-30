package com.bw.movie.mvp.present;

import android.util.Log;

import com.bw.movie.mvp.model.AttenModel;
import com.bw.movie.mvp.model.bean.UnflowwBean;
import com.bw.movie.IView.IUnAttenView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：轻 on 2018/11/19 11:50
 * <p>
 * 邮箱：379996854@qq.com
 */
public class UnFlowwAttenPresent extends BasePresent<IUnAttenView> {

    AttenModel attenModel;
    IUnAttenView iUnAttenView;

    public UnFlowwAttenPresent(IUnAttenView iUnAttenView){

        this.iUnAttenView=iUnAttenView;
        attenModel=new AttenModel();
    }

    public  void getUnfloww(int movieId){

        attenModel.getUnfloww(movieId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UnflowwBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UnflowwBean unflowwBean) {

                        iUnAttenView.success(unflowwBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.i("onError ==", "onError: ===="+e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

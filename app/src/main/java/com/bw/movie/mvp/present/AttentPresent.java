package com.bw.movie.mvp.present;

import android.util.Log;

import com.bw.movie.mvp.model.AttenModel;
import com.bw.movie.mvp.model.bean.AttenBean;
import com.bw.movie.IView.IAttentView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：轻 on 2018/11/17 16:17
 * <p>
 * 邮箱：379996854@qq.com
 */
public class AttentPresent extends BasePresent<IAttentView> {

    IAttentView iAttentView;
    AttenModel attenModel;

    public AttentPresent(IAttentView iAttentView){

        this.iAttentView=iAttentView;
        attenModel=new AttenModel();
    }

    public  void getAttent(int movieId){

        attenModel.getAtten(movieId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AttenBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AttenBean attenBean) {

                        iAttentView.success(attenBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.i("onError AttenModel", "onError: ===="+e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

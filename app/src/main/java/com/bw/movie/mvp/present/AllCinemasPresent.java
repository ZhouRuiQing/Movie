package com.bw.movie.mvp.present;

import android.util.Log;

import com.bw.movie.mvp.model.bean.AllCinemasBean;
import com.bw.movie.mvp.model.ModelAllCinemas;
import com.bw.movie.IView.IAllCinemas;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：轻 on 2018/11/9 18:57
 * <p>
 * 邮箱：379996854@qq.com
 */
public class AllCinemasPresent extends BasePresent<IAllCinemas> {

    IAllCinemas iAllCinemas;
    ModelAllCinemas modelAllCinemas;

    public AllCinemasPresent(IAllCinemas iAllCinemas){

        this.iAllCinemas=iAllCinemas;
        modelAllCinemas=new ModelAllCinemas();
    }

    public void  getAllCinemas(int page,int count){

        modelAllCinemas.getAllCinemas(page,count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AllCinemasBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AllCinemasBean allCinemasBean) {

                        iAllCinemas.success(allCinemasBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.i("aaa","e===="+e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}

package com.bw.movie.mvp.present;

import android.util.Log;

import com.bw.movie.mvp.model.UserModel;
import com.bw.movie.mvp.model.bean.RegBean;
import com.bw.movie.mvp.view.IView.IRegView;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：轻 on 2018/11/14 11:19
 * <p>
 * 邮箱：379996854@qq.com
 */
public class RegPresent extends BasePresent<IRegView> {

    UserModel userModel;
    IRegView iRegView;

    public RegPresent(IRegView iRegView){

        this.iRegView=iRegView;
        userModel=new UserModel();
    }


    public  void getReg(HashMap<String, String> map){

        userModel.getReg(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<RegBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegBean regBean) {

                        iRegView.success(regBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.i("aaa", "onError: ===="+e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}

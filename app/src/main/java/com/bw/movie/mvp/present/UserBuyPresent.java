package com.bw.movie.mvp.present;

import android.util.Log;

import com.bw.movie.mvp.model.UserModel;
import com.bw.movie.mvp.model.bean.UserBuyBean;
import com.bw.movie.mvp.view.IView.IUserBuyView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：轻 on 2018/11/16 10:43
 * <p>
 * 邮箱：379996854@qq.com
 */
public class UserBuyPresent extends BasePresent<IUserBuyView>{

    IUserBuyView iUserBuyView;
    UserModel userModel;

    public UserBuyPresent(IUserBuyView iUserBuyView){

        this.iUserBuyView=iUserBuyView;
        userModel=new UserModel();
    }

    public  void getUserBuy(int page,int count){

        userModel.getUserBuy(page,count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserBuyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserBuyBean userBuyBean) {

                        iUserBuyView.success(userBuyBean);
                        //Log.i("onNext", "onNext: ==="+userBuyBean.getResult().toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.i("aaa", "onError: ====="+e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}

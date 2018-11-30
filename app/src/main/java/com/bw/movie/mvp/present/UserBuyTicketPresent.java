package com.bw.movie.mvp.present;

import android.util.Log;

import com.bw.movie.IView.IUserBuyTickenView;
import com.bw.movie.mvp.model.UserModel;
import com.bw.movie.mvp.model.bean.UserBuyTicketBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：轻 on 2018/11/23 20:20
 * <p>
 * 邮箱：379996854@qq.com
 */
public class UserBuyTicketPresent extends BasePresent<IUserBuyTickenView> {

    IUserBuyTickenView iUserBuyTickenView;
    UserModel userModel;

    public UserBuyTicketPresent(IUserBuyTickenView iUserBuyTickenView){

        this.iUserBuyTickenView=iUserBuyTickenView;
        userModel=new UserModel();
    }

    public void getUserBuyTicket(int page,int count){

        userModel.getUserBuyTicket(page,count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserBuyTicketBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserBuyTicketBean userBuyTicketBean) {

                        iUserBuyTickenView.success(userBuyTicketBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error====","shibai"+e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}

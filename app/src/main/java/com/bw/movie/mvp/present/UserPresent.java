package com.bw.movie.mvp.present;

import com.bw.movie.mvp.model.UserModel;
import com.bw.movie.mvp.model.bean.UserBean;
import com.bw.movie.mvp.view.IView.IUserView;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：轻 on 2018/11/14 11:03
 * <p>
 * 邮箱：379996854@qq.com
 */
public class UserPresent extends BasePresent<IUserView>{

    UserModel userModel;
    IUserView iUserView;

    public UserPresent( IUserView iUserView){

        this.iUserView=iUserView;
        userModel=new UserModel();
    }

    public void getUser(HashMap<String, String> map){

        userModel.getUser(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserBean userBean) {

                        iUserView.success(userBean);
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

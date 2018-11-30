package com.bw.movie.mvp.present;

import com.bw.movie.IView.IFeedBackView;
import com.bw.movie.mvp.model.UserModel;
import com.bw.movie.mvp.model.bean.FeedBackBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：轻 on 2018/11/27 09:00
 * <p>
 * 邮箱：379996854@qq.com
 */
public class FeedBackPresent extends BasePresent<IFeedBackView> {

    IFeedBackView iFeedBackView;
    UserModel userModel;

    public FeedBackPresent(IFeedBackView iFeedBackView){

        this.iFeedBackView=iFeedBackView;
        userModel=new UserModel();
    }

    public void getfeedback(String content){

        userModel.getfeedback(content)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<FeedBackBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FeedBackBean feedBackBean) {

                        iFeedBackView.success(feedBackBean);
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

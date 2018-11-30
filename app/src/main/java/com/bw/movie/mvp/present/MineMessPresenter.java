package com.bw.movie.mvp.present;

import com.bw.movie.mvp.model.UserModel;
import com.bw.movie.mvp.model.bean.ChageTouBean;
import com.bw.movie.IView.IChageView;

import java.io.File;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：轻 on 2018/11/20 15:41
 * <p>
 * 邮箱：379996854@qq.com
 */
public class MineMessPresenter extends BasePresent<IChageView>{

    IChageView iChageView;
    UserModel userModel;


    public MineMessPresenter(IChageView iChageView){

        this.iChageView=iChageView;
        userModel=new UserModel();
    }

    public void getChageTou(File file){

        userModel.getChageTou(file)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ChageTouBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ChageTouBean chageTouBean) {

                        iChageView.success(chageTouBean);
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

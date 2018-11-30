package com.bw.movie.mvp.present;

import android.util.Log;

import com.bw.movie.mvp.model.ModelModifyPwd;
import com.bw.movie.mvp.model.bean.ModifyPwdBean;
import com.bw.movie.IView.IModifyPwdView;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：轻 on 2018/11/19 15:37
 * <p>
 * 邮箱：379996854@qq.com
 */
public class ModifyPwdPresent extends BasePresent<IModifyPwdView>{

    IModifyPwdView iModifyPwdView;
    ModelModifyPwd modelModifyPwd;

    public ModifyPwdPresent(IModifyPwdView iModifyPwdView){

        this.iModifyPwdView=iModifyPwdView;
        modelModifyPwd=new ModelModifyPwd();
    }

    public void getModifyPwd(HashMap<String, String> map){

        modelModifyPwd.getModifyPwd(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ModifyPwdBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ModifyPwdBean modifyPwdBean) {

                        iModifyPwdView.success(modifyPwdBean);
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

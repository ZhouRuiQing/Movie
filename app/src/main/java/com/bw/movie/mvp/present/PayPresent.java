package com.bw.movie.mvp.present;

import com.bw.movie.IView.IPayView;
import com.bw.movie.mvp.model.ModelPay;
import com.bw.movie.mvp.model.bean.PayBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：轻 on 2018/11/22 14:35
 * <p>
 * 邮箱：379996854@qq.com
 */
public class PayPresent extends BasePresent<IPayView> {

    IPayView iPayView;
    ModelPay modelPay;

    public PayPresent(IPayView iPayView){

        this.iPayView=iPayView;
        modelPay=new ModelPay();
    }

    public void  getPay(int payType,String orderId){

        modelPay.getPay(payType,orderId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<PayBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PayBean payBean) {

                        iPayView.success(payBean);
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

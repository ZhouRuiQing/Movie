package com.bw.movie.mvp.present;

import com.bw.movie.IView.IShopOrderView;
import com.bw.movie.mvp.model.ModelPay;
import com.bw.movie.mvp.model.bean.IndentBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：轻 on 2018/11/22 15:39
 * <p>
 * 邮箱：379996854@qq.com
 */
public class ShopOrderPresent extends BasePresent<IShopOrderView> {

    IShopOrderView iShopOrderView;
    ModelPay modelPay;


    public  ShopOrderPresent(IShopOrderView iShopOrderView){

        this.iShopOrderView=iShopOrderView;
        modelPay=new ModelPay();
    }

    public void  getShopOrder(int scheduleId,int amount,String sign){
        modelPay.getShopOrder(scheduleId, amount, sign)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<IndentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(IndentBean indentBean) {

                        iShopOrderView.success(indentBean);
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

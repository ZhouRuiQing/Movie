package com.bw.movie.mvp.present;

import com.bw.movie.mvp.model.bean.DetailMovie;
import com.bw.movie.mvp.model.DetaModel;
import com.bw.movie.mvp.view.IView.IDetaView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DetaPresent extends BasePresent<IDetaView>{

    DetaModel detaModel;
    IDetaView iDetaView;

    public  DetaPresent(IDetaView iDetaView){

        this.iDetaView=iDetaView;
        detaModel = new DetaModel();
    }

    public void getDetaMovie(int movieid){

        detaModel.getDetaMovie(movieid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<DetailMovie>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DetailMovie detailMovie) {

                        iDetaView.success(detailMovie);
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

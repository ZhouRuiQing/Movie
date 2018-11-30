package com.bw.movie.mvp.present;

import com.bw.movie.mvp.model.ModelCinemes;
import com.bw.movie.mvp.model.bean.CommentBean;
import com.bw.movie.IView.ICommentView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：轻 on 2018/11/13 21:10
 * <p>
 * 邮箱：379996854@qq.com
 */
public class CommentPresent extends BasePresent<ICommentView> {

    ModelCinemes modelCinemes;
    ICommentView iCommentView;

    public  CommentPresent(ICommentView iCommentView){

        this.iCommentView=iCommentView;
        modelCinemes=new ModelCinemes();
    }

    public void getCinmeas(int cinemaId,int page,int count){

        modelCinemes.getConmment(cinemaId,page,count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<CommentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CommentBean commentBean) {

                        iCommentView.success(commentBean);
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

package com.bw.movie.mvp.view.IView;

import com.bw.movie.mvp.model.bean.ComingMovie;

public interface IComingView extends IBaseView {

    void Sueecss(ComingMovie comingMovie);
    void Error(String msg);
}

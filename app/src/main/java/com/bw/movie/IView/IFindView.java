package com.bw.movie.IView;

import com.bw.movie.mvp.model.bean.MovieFindinfo;

public interface IFindView extends IBaseView {

    void success(MovieFindinfo movieFindinfo);
    void Error(String msg);
}

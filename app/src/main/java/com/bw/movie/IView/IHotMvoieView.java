package com.bw.movie.IView;

import com.bw.movie.mvp.model.bean.Movieinfo;

public interface IHotMvoieView extends IBaseView {

    void success(Movieinfo movieinfo);
    void Error(String msg);
}

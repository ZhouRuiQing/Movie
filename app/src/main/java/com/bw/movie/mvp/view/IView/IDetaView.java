package com.bw.movie.mvp.view.IView;

import com.bw.movie.mvp.model.bean.DetailMovie;

public interface IDetaView extends IBaseView {

    void success(DetailMovie detailMovie);
    void Error(String msg);
}

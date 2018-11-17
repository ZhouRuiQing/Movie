package com.bw.movie.mvp.view.IView;

import com.bw.movie.mvp.model.bean.FindCinemesBean;

public interface ICinemesView extends IBaseView {

    void success(FindCinemesBean cinemesBean);
    void Error(String msg);

}

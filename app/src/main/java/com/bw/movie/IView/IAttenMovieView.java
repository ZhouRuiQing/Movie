package com.bw.movie.IView;

import com.bw.movie.mvp.model.bean.AttenMovieBean;

/**
 * 作者：轻 on 2018/11/21 09:28
 * <p>
 * 邮箱：379996854@qq.com
 */
public interface IAttenMovieView extends IBaseView {

    void success(AttenMovieBean attenMovieBean);
    void Error(String msg);
}

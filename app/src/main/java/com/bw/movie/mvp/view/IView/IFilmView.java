package com.bw.movie.mvp.view.IView;

import com.bw.movie.mvp.model.bean.FilmBean;

/**
 * 作者：轻 on 2018/11/9 13:41
 * <p>
 * 邮箱：379996854@qq.com
 */
public interface IFilmView extends IBaseView {

    void  success(FilmBean filmBean);
    void  Error(String msg);
}
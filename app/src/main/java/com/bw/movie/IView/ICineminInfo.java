package com.bw.movie.IView;

import com.bw.movie.mvp.model.bean.CinemaInfoBean;

/**
 * 作者：轻 on 2018/11/12 14:58
 * <p>
 * 邮箱：379996854@qq.com
 */
public interface ICineminInfo extends IBaseView {

    void  success(CinemaInfoBean cinemaInfoBean);
    void  Error(String msg);
}

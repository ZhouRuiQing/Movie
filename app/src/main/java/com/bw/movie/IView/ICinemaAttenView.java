package com.bw.movie.IView;

import com.bw.movie.mvp.model.bean.AttenCinemaBean;

/**
 * 作者：轻 on 2018/11/21 11:32
 * <p>
 * 邮箱：379996854@qq.com
 */
public interface ICinemaAttenView extends IBaseView {

    void success(AttenCinemaBean attenCinemaBean);
    void Error(String msg);
}

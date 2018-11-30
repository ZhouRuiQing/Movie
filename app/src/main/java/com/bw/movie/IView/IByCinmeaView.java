package com.bw.movie.IView;

import com.bw.movie.mvp.model.bean.ByCinemaBean;

/**
 * 作者：轻 on 2018/11/15 19:49
 * <p>
 * 邮箱：379996854@qq.com
 */
public interface IByCinmeaView extends IBaseView {

    void success(ByCinemaBean byCinemaBean);
    void Error(String msg);
}

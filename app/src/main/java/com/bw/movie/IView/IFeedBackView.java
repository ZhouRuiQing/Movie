package com.bw.movie.IView;

import com.bw.movie.mvp.model.bean.FeedBackBean;

/**
 * 作者：轻 on 2018/11/27 09:00
 * <p>
 * 邮箱：379996854@qq.com
 */
public interface IFeedBackView extends IBaseView {

    void success(FeedBackBean feedBackBean);
    void Error(String msg);
}

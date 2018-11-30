package com.bw.movie.IView;

import com.bw.movie.mvp.model.bean.WeEBean;

/**
 * 作者：轻 on 2018/11/21 19:50
 * <p>
 * 邮箱：379996854@qq.com
 */
public interface IWeiEView extends IBaseView {

    void success(WeEBean weEBean);
    void Error(String msg);
}

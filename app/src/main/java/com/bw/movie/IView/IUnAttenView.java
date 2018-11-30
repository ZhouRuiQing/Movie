package com.bw.movie.IView;

import com.bw.movie.mvp.model.bean.UnflowwBean;

/**
 * 作者：轻 on 2018/11/19 11:51
 * <p>
 * 邮箱：379996854@qq.com
 */
public interface IUnAttenView extends IBaseView {

    void success(UnflowwBean unflowwBean);
    void Error(String msg);
}

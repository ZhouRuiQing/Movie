package com.bw.movie.IView;

import com.bw.movie.mvp.model.bean.PayBean;

/**
 * 作者：轻 on 2018/11/22 14:36
 * <p>
 * 邮箱：379996854@qq.com
 */
public interface IPayView extends IBaseView {

    void success(PayBean payBean);
    void Error(String msg);
}

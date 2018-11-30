package com.bw.movie.IView;

import com.bw.movie.mvp.model.bean.IndentBean;

/**
 * 作者：轻 on 2018/11/22 15:39
 * <p>
 * 邮箱：379996854@qq.com
 */
public interface IShopOrderView extends IBaseView {

    void success(IndentBean indentBean);
    void Error(String msg);
}

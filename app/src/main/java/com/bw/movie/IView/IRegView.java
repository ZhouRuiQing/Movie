package com.bw.movie.IView;

import com.bw.movie.mvp.model.bean.RegBean;

/**
 * 作者：轻 on 2018/11/14 11:20
 * <p>
 * 邮箱：379996854@qq.com
 */
public interface IRegView extends IBaseView {

    void success(RegBean regBean);
    void Error(String msg);
}

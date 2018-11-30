package com.bw.movie.IView;

import com.bw.movie.mvp.model.bean.ChageTouBean;

/**
 * 作者：轻 on 2018/11/20 15:42
 * <p>
 * 邮箱：379996854@qq.com
 */
public interface IChageView extends IBaseView {

    void success(ChageTouBean chageTouBean);
    void Error(String msg);
}

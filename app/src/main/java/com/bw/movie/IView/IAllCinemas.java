package com.bw.movie.IView;

import com.bw.movie.mvp.model.bean.AllCinemasBean;

/**
 * 作者：轻 on 2018/11/9 18:53
 * <p>
 * 邮箱：379996854@qq.com
 */
public interface IAllCinemas extends IBaseView {

    void success(AllCinemasBean allCinemasBean);
    void Error(String msg);
}

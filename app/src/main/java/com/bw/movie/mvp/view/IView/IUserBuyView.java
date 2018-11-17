package com.bw.movie.mvp.view.IView;

import com.bw.movie.mvp.model.bean.UserBuyBean;

/**
 * 作者：轻 on 2018/11/16 10:45
 * <p>
 * 邮箱：379996854@qq.com
 */
public interface IUserBuyView extends IBaseView {

    void success(UserBuyBean userBuyBean);
    void Error(String msg);
}

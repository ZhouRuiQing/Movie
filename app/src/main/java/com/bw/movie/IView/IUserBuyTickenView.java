package com.bw.movie.IView;

import com.bw.movie.mvp.model.bean.UserBuyTicketBean;

/**
 * 作者：轻 on 2018/11/23 20:23
 * <p>
 * 邮箱：379996854@qq.com
 */
public interface IUserBuyTickenView extends IBaseView {

    void success(UserBuyTicketBean userBuyTicketBean);
    void Error(String msg);
}

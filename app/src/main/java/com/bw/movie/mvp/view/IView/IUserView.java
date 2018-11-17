package com.bw.movie.mvp.view.IView;

import com.bw.movie.mvp.model.bean.UserBean;

/**
 * 作者：轻 on 2018/11/14 11:04
 * <p>
 * 邮箱：379996854@qq.com
 */
public interface IUserView extends IBaseView {

    void  success(UserBean userBean);

}

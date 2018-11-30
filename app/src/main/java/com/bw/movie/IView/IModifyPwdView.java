package com.bw.movie.IView;

import com.bw.movie.mvp.model.bean.ModifyPwdBean;

/**
 * 作者：轻 on 2018/11/19 15:38
 * <p>
 * 邮箱：379996854@qq.com
 */
public interface IModifyPwdView  extends IBaseView{

    void success(ModifyPwdBean modifyPwdBean);
    void Error(String msg);
}

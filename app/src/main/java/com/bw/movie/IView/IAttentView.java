package com.bw.movie.IView;

import com.bw.movie.mvp.model.bean.AttenBean;

/**
 * 作者：轻 on 2018/11/17 16:18
 * <p>
 * 邮箱：379996854@qq.com
 */
public interface IAttentView extends IBaseView{

    void  success(AttenBean attenBean);
    void Error(String msg);
}

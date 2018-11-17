package com.bw.movie.mvp.view.IView;

import com.bw.movie.mvp.model.bean.CommentBean;

/**
 * 作者：轻 on 2018/11/13 21:09
 * <p>
 * 邮箱：379996854@qq.com
 */
public interface ICommentView extends IBaseView {

    void success(CommentBean commentBean);
    void Error(String msg);
}

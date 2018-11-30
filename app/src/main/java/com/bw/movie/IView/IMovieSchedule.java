package com.bw.movie.IView;

import com.bw.movie.mvp.model.bean.ScheduleBean;

/**
 * 作者：轻 on 2018/11/14 16:32
 * <p>
 * 邮箱：379996854@qq.com
 */
public interface IMovieSchedule extends IBaseView {

    void success(ScheduleBean scheduleBean);
    void Error(String msg);
}

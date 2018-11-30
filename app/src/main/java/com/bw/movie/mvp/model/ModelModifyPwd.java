package com.bw.movie.mvp.model;

import com.bw.movie.mvp.model.bean.ModifyPwdBean;
import com.bw.movie.mvp.model.utils.HttpUtils;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * 作者：轻 on 2018/11/19 15:30
 * <p>
 * 邮箱：379996854@qq.com
 */
public class ModelModifyPwd {

    //修改密码
    public Observable<ModifyPwdBean>  getModifyPwd(HashMap<String, String> map){

       return  HttpUtils.getInstance().api.getModifyPwd(map);
    }

}

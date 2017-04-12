package com.xupt.zxh.graduation.project.service;

import com.xupt.zxh.graduation.project.bean.User;

/**
 * Created by 张涛 on 2017/4/12.
 */
public interface AccountService {

    /**
     * 登录
     * @param user
     * @return
     */
    boolean login(User user);

}

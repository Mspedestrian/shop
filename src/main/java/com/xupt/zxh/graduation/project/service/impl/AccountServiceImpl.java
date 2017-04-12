package com.xupt.zxh.graduation.project.service.impl;

import com.xupt.zxh.graduation.project.bean.User;
import com.xupt.zxh.graduation.project.service.AccountService;
import com.xupt.zxh.graduation.project.util.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 张涛 on 2017/4/12.
 */
@Service
public class AccountServiceImpl implements AccountService {



    @Autowired
    private HttpServletRequest httpServletRequest;


    @Override
    public boolean login(User user) {
        if(user == null){
            return false;
        }
        String usernameReal = ConstantsUtil.getValue("username");
        String passwordReal = ConstantsUtil.getValue("password");
        if(usernameReal.equals(user.getUsername()) && passwordReal.equals(user.getPassword())){
            httpServletRequest.getSession().setMaxInactiveInterval(60*30);
            String sessionId = httpServletRequest.getSession().getId();
            if(httpServletRequest.getSession().getAttribute(sessionId) != null){
                return true;
            }
            httpServletRequest.getSession().setAttribute(sessionId,usernameReal);
            return true;
        }
        return false;
    }
}

package com.xupt.zxh.graduation.project.controller;

import com.xupt.zxh.graduation.project.bean.Commodity;
import com.xupt.zxh.graduation.project.bean.ResponseInfo;
import com.xupt.zxh.graduation.project.bean.User;
import com.xupt.zxh.graduation.project.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 账户相关接口
 * Created by 张涛 on 2017/4/12.
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController {


    @Autowired
    private AccountService accountService;

    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    public @ResponseBody ResponseInfo login(@RequestBody User user){
        ResponseInfo responseInfo = new ResponseInfo();
        boolean result = accountService.login(user);
        if(!result){
            responseInfo.setCode(ResponseInfo.FAIL);
            responseInfo.setDesc("登录失败");
            return responseInfo;
        }
        responseInfo.setDesc("登录成功");
        return responseInfo;
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    public @ResponseBody ResponseInfo logout(){
        ResponseInfo responseInfo = new ResponseInfo();
        boolean result = accountService.logout();
        if(!result){
            responseInfo.setCode(ResponseInfo.FAIL);
            responseInfo.setDesc("退出失败");
            return responseInfo;
        }
        return responseInfo;
    }

    /**
     * 登录失败的时候用于返回需要登录的提示信息
     * @return
     */
    @RequestMapping(value = "/needLogin",method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    public @ResponseBody ResponseInfo needLogin(){
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setCode(ResponseInfo.FAIL);
        responseInfo.setDesc("没有登录");
        return responseInfo;
    }


}

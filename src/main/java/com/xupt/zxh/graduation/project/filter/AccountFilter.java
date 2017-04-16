package com.xupt.zxh.graduation.project.filter;

import com.xupt.zxh.graduation.project.util.ConstantsUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 账户过滤器，用于验证用户是否登录
 * Created by 张涛 on 2017/4/16.
 */
public class AccountFilter implements Filter {

    /**
     * 从配置文件中读取
     */
    private String uncheckPath = null;

    /**
     * 没有登录的时候跳转地址
     */
    private static final String redirectPath = "/account/needLogin";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        uncheckPath = ConstantsUtil.getValue("uncheckPath");
        System.out.println(uncheckPath);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1.得到访问路径
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String reqUrl = request.getRequestURL().toString();
        String reqURI = request.getRequestURI();

        String servletPath = request.getServletPath();

        //  String[] uncheckUrl = uncheckUrls.split(",");
        List<String> urls = Arrays.asList(uncheckPath.split(","));
        //2.如果是属于不需要过滤的地址就直接  放行  方法结束
        for (String url : urls){
            if(servletPath.indexOf(url) != -1){
                filterChain.doFilter(request, response);
                return;
            }
        }

        //3.从获取请求的session，并获取session ID 检测sessionID已经被存储，存储则放行，否则需要登录
        String sessionId = request.getSession().getId();
        Object username = request.getSession().getAttribute(sessionId);
        if(username == null){
            request.getRequestDispatcher(redirectPath).forward(request,response);
            return;
        }
        //4若存在 则放行；
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}

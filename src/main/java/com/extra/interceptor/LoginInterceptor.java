package com.extra.interceptor;

import com.extra.model.ManagerBean;
import com.extra.utils.SessionUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.extra.utils.SessionUtils.SESSION_MANAGER;

/**
 * Created by Extra on 2017/10/31.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private Logger log = Logger.getLogger(LoginInterceptor.class);

    private boolean flag=false;
    private static final String[] IGNORE_URI={"/login","/singin"};
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());

        //判断请求是否需要拦截
        for(String s:IGNORE_URI){
            if(url.contains(s)){
                flag=true;    //如果是不拦截的网站，flag为true,跳出循环，转向下个方法
                break;
            }
        }

        if (flag) return true;

        log.info("requestUri:"+requestUri);
        log.info("contextPath:"+contextPath);
        log.info("url:"+url);
        ManagerBean managerBean = (ManagerBean) request.getSession().getAttribute(SESSION_MANAGER);
        if(managerBean == null){
            log.info("==============执行顺序: 1、preHandle================");
            response.sendRedirect("/login");
            return false;
        }else
            return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("==============执行顺序: 2、postHandle================");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("==============执行顺序: 3、afterCompletion================");
        super.afterCompletion(request, response, handler, ex);
    }
}

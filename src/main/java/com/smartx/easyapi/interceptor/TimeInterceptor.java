package com.smartx.easyapi.interceptor;

import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * </p>
 *
 * <b>Creation Time:</b> 2017/11/14
 *
 * @author kext
 */
@Slf4j
public class TimeInterceptor extends HandlerInterceptorAdapter {

    private NamedThreadLocal<Long> timeThreadLocal = new NamedThreadLocal<>("ExecuteTime");

    private static final String LOG_EXECUTE_TIME = "Execute Time: {}ms";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        timeThreadLocal.set(System.nanoTime());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info(LOG_EXECUTE_TIME, TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - timeThreadLocal.get()));
    }
}

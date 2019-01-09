package com.smartx.easyapi.filter;

import com.smartx.easyapi.bean.wrapper.RequestWrapper;
import com.smartx.easyapi.bean.wrapper.ResponseWrapper;

import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * </p>
 *
 * <b>Creation Time:</b> 2017/11/15
 *
 * @author kext
 */
@Slf4j
public class LogFilter extends OncePerRequestFilter {

    private static final String LOG_REQUEST = "Api: {}, Request: {}";

    private static final String LOG_RESPONSE = "Api: {}, Response: {}";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        RequestWrapper requestWrapper = new RequestWrapper(httpServletRequest);
        ResponseWrapper responseWrapper = new ResponseWrapper(httpServletResponse);
        try {
            filterChain.doFilter(requestWrapper, responseWrapper);
        } catch (Exception e) {
            log.error("Error to filter", e);
        } finally {
            // log request and response
            log.info(LOG_REQUEST, httpServletRequest.getRequestURI(), requestWrapper.getBodyString());
            log.info(LOG_RESPONSE, httpServletRequest.getRequestURI(), responseWrapper.getBodyString());
        }
    }
}

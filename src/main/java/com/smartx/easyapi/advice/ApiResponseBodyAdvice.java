package com.smartx.easyapi.advice;

import com.google.common.base.Strings;

import com.smartx.easyapi.bean.api.ApiRequest;
import com.smartx.easyapi.bean.api.ApiResponse;
import com.smartx.easyapi.bean.wrapper.RequestWrapper;
import com.smartx.easyapi.util.JsonUtil;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * </p>
 *
 * <b>Creation Time:</b> 2017/11/16
 *
 * @author kext
 */
@ControllerAdvice
@Slf4j
public class ApiResponseBodyAdvice implements ResponseBodyAdvice<ApiResponse> {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return returnType.getMethod().getReturnType().isAssignableFrom(ApiResponse.class);
    }

    @Override
    public ApiResponse beforeBodyWrite(ApiResponse body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (Strings.isNullOrEmpty(body.getId())) {
            ServletServerHttpRequest servletServerHttpRequest = (ServletServerHttpRequest) request;
            HttpServletRequest httpServletRequest = servletServerHttpRequest.getServletRequest();
            RequestWrapper requestWrapper = (RequestWrapper) httpServletRequest;
            try {
                ApiRequest apiRequest = JsonUtil.json2Object(requestWrapper.getBodyString(), ApiRequest.class);
                body.setId(apiRequest.getId());
            } catch (IOException e) {
                log.error("json2Object Exception", e);
            }
        }
        return body;
    }
}

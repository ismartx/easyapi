package com.smartx.easyapi.interceptor;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

import com.smartx.easyapi.bean.api.ApiRequest;
import com.smartx.easyapi.bean.api.ApiResponse;
import com.smartx.easyapi.bean.api.StateCode;
import com.smartx.easyapi.bean.wrapper.RequestWrapper;
import com.smartx.easyapi.config.ApiConfig;
import com.smartx.easyapi.util.JsonUtil;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *
 * </p>
 *
 * <b>Creation Time:</b> 2018/4/21
 *
 * @author kext
 */
public class RequestInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private ApiConfig apiConfig;

    private static final String SIGN_FORMAT = "%s:%s:%s";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        RequestWrapper requestWrapper = new RequestWrapper(request);
        ApiResponse apiResponse = null;
        try {
            ApiRequest apiRequest = JsonUtil.json2Object(requestWrapper.getBodyString(), ApiRequest.class);
            String signString = String.format(SIGN_FORMAT, apiRequest.getId(), apiConfig.getSecret(), apiRequest.getTimestamp());
            String md5 = Hashing.md5().hashString(signString, Charsets.UTF_8).toString();
            if (!md5.equals(apiRequest.getSign())) {
                apiResponse = ApiResponse.builder()
                        .id(apiRequest.getId())
                        .state(StateCode.SIGN_ERROR)
                        .build();
            }
        } catch (IOException e) {
            apiResponse = ApiResponse.builder().state(StateCode.REQUEST_ERROR).build();
        }
        if (null != apiResponse) {
            response.getWriter().write(JsonUtil.object2Json(apiResponse));
            return false;
        }
        return true;
    }
}

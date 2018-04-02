package com.smartx.easyapi.advice;

import com.smartx.easyapi.bean.api.ApiResponse;
import com.smartx.easyapi.bean.api.StateCode;
import com.smartx.easyapi.exception.ServiceException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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
@ControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler({Exception.class, Throwable.class})
    @ResponseBody
    public ApiResponse exceptionHandler(Exception e) {
        log.error("Exception: ", e);
        return ApiResponse.builder().id("").state(StateCode.ERROR).build();
    }

    @ExceptionHandler({ServiceException.class})
    @ResponseBody
    public ApiResponse serviceExceptionHandler(ServiceException e) {
        log.error("ServiceException: ", e);
        return ApiResponse.builder().id("").state(e.getState()).build();
    }

}

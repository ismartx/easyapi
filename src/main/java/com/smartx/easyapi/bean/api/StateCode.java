package com.smartx.easyapi.bean.api;

/**
 * <p>
 * API框架状态码
 * </p>
 *
 * <b>Creation Time:</b> 2017/11/15
 *
 * @author kext
 */
public final class StateCode {
    public static final State SUCCESSFUL = State.builder().code(0).msg("").build();
    public static final State ERROR = State.builder().code(10001).msg("server error").build();
    public static final State REQUEST_ERROR = State.builder().code(10002).msg("request error").build();
    public static final State SIGN_ERROR = State.builder().code(10003).msg("sign error").build();
}

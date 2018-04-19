package com.smartx.easyapi.bean.api;

import java.io.Serializable;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * <b>Creation Time:</b> 2018/4/19
 *
 * @author kext
 */
@Data
public class Client implements Serializable {

    private static final long serialVersionUID = -7333072327106470695L;
    private String source;

    private String ver;
}

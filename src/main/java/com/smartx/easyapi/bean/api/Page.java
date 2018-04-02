package com.smartx.easyapi.bean.api;

import java.io.Serializable;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * <b>Creation Time:</b> 2017/11/10
 *
 * @author kext
 */
@Data
public class Page implements Serializable {

    private Integer page;

    private Integer size;

    private Integer totalPage;
}

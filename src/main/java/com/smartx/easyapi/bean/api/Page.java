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

    private static final long serialVersionUID = 1711652616692842368L;
    private Integer page;

    private Integer size;

    private Integer totalPage;
}

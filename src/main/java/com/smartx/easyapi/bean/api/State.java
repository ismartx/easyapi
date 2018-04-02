package com.smartx.easyapi.bean.api;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class State implements Serializable {

    private Integer code;

    private String msg;
}

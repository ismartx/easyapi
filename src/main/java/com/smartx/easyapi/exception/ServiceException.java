package com.smartx.easyapi.exception;

import com.smartx.easyapi.bean.api.State;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *
 * </p>
 *
 * <b>Creation Time:</b> 2017/11/15
 *
 * @author kext
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceException extends Exception {

    private State state;

    public ServiceException(String message, Throwable t) {
        super(message, t);
    }

}

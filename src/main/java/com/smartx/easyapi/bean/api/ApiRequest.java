package com.smartx.easyapi.bean.api;

import java.io.Serializable;
import java.util.Map;

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
public class ApiRequest implements Serializable {

    private String id;

    private String sign;

    private Long timestamp;

    private Client client;

    private Map<String, Object> data;

    private Page page;

    private User user;

    public String getDataParamAsString(String key) {
        return getDataParam(key) != null ? getDataParam(key).toString() : null;
    }

    public Integer getDataParamAsInteger(String key) {
        return getDataParamAsString(key) != null ? Integer.valueOf(getDataParamAsString(key)) : null;
    }

    public Object getDataParam(String key) {
        if (this.data == null || key == null) {
            return null;
        }
        return this.data.get(key);
    }
}

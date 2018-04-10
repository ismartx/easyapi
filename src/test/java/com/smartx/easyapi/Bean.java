package com.smartx.easyapi;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * <b>Creation Time:</b> 2018/4/10
 *
 * @author kext
 */
public class Bean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}

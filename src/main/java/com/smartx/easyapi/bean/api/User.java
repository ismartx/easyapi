package com.smartx.easyapi.bean.api;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *
 * </p>
 *
 * <b>Creation Time:</b> 2017/11/22
 *
 * @author kext
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -231027225368206064L;
    private Integer userId;

    private String sessionId;

    public static User newUser(Integer userId) {
        return new User(userId, UUID.randomUUID().toString().replace("-", ""));
    }
}

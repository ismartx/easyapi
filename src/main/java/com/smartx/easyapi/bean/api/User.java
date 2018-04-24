package com.smartx.easyapi.bean.api;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = -231027225368206064L;
    private Integer userId;

    private String sessionId;

    private Integer expires;

    public static User newUser(Integer userId) {
        return newUser(userId, -1);
    }

    public static User newUser(Integer userId, Integer expires) {
        return new User(userId, UUID.randomUUID().toString().replace("-", ""), expires);
    }
}

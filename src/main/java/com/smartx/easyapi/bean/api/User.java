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
    private String userId;

    private String sessionId;

    private Integer expires;

    public static User newUser(String userId) {
        return newUser(userId, -1);
    }

    public static User newUser(String userId, Integer expires) {
        return new User(userId, generateSid(), expires);
    }

    public static String generateSid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Integer getUserIdInt() {
        if (this.userId != null && this.userId.matches("\\d+")) {
            return Integer.valueOf(this.userId);
        }
        return null;
    }
}

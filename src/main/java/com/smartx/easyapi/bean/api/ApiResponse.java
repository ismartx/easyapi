package com.smartx.easyapi.bean.api;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse implements Serializable {

    private static final long serialVersionUID = -832472078245067047L;
    private String id;

    private State state;

    private Map<String, Object> data;

    private Page page;

    private User user;

    private static final int COLLECTION_DEFAULT_SIZE = 16;

    public static class ApiResponseBuilder {
        private String id;
        private State state;
        private Map<String, Object> data;
        private Page page;
        private User user;

        ApiResponseBuilder() {
        }

        public ApiResponse.ApiResponseBuilder id(String id) {
            this.id = id;
            return this;
        }

        public ApiResponse.ApiResponseBuilder state(State state) {
            this.state = state;
            return this;
        }

        public ApiResponse.ApiResponseBuilder user(User user) {
            this.user = user;
            return this;
        }

        public ApiResponse.ApiResponseBuilder ok() {
            this.state = StateCode.SUCCESSFUL;
            return this;
        }

        public ApiResponse.ApiResponseBuilder error() {
            this.state = StateCode.ERROR;
            return this;
        }

        public ApiResponse.ApiResponseBuilder requestError() {
            this.state = StateCode.REQUEST_ERROR;
            return this;
        }

        public ApiResponse.ApiResponseBuilder signError() {
            this.state = StateCode.SIGN_ERROR;
            return this;
        }

        public ApiResponse.ApiResponseBuilder data(Map<String, Object> data) {
            this.data = data;
            return this;
        }

        public ApiResponse.ApiResponseBuilder addObjectToData(Object obj) throws Exception {
            this.addObjectToData0(null, obj, false, false);
            return this;
        }

        public ApiResponse.ApiResponseBuilder addObjectToData(String key, Object obj) throws Exception {
            this.addObjectToData0(key, obj, false, false);
            return this;
        }

        public ApiResponse.ApiResponseBuilder addObjectToData(String key, Object obj, boolean withNullField) throws Exception {
            this.addObjectToData0(key, obj, withNullField, false);
            return this;
        }

        public ApiResponse.ApiResponseBuilder addObjectToData(String key, Object obj, boolean withNullField, boolean withName) throws Exception {
            this.addObjectToData0(key, obj, withNullField, withName);
            return this;
        }

        public ApiResponse.ApiResponseBuilder addValueToData(String key, Object value) {
            this.addValueToData0(key, value);
            return this;
        }

        public <T> ApiResponse.ApiResponseBuilder addListToData(List<T> list) {
            this.addListToData0("dataList", list);
            return this;
        }

        public <T> ApiResponse.ApiResponseBuilder addListToData(String key, List<T> list) {
            this.addListToData0(key, list);
            return this;
        }

        public ApiResponse.ApiResponseBuilder page(Page page) {
            this.page = page;
            return this;
        }

        public ApiResponse build() {
            return new ApiResponse(this.id, this.state, this.data, this.page, this.user);
        }

        @Override
        public String toString() {
            return "ApiResponse.ApiResponseBuilder(id=" + this.id + ", state=" + this.state + ", data=" + this.data + ", page=" + this.page + ")";
        }

        private void addObjectToData0(String key, Object obj, boolean withNullField, boolean withName) throws Exception {
            if (this.data == null) {
                this.data = new HashMap<>(COLLECTION_DEFAULT_SIZE);
            }
            Map<String, Object> map = this.map(obj, withNullField);
            if (key != null) {
                this.data.put(key, map);
            } else {
                if (withName) {
                    this.data.put(obj.getClass().getSimpleName().toLowerCase(), map);
                } else {
                    this.data.putAll(map);
                }
            }
        }

        private Map<String, Object> map(Object obj, boolean withNullField) throws Exception {
            Map<String, Object> map = new HashMap<>(COLLECTION_DEFAULT_SIZE);
            for (Field f : obj.getClass().getDeclaredFields()) {
                if ("this$0".equals(f.getName()) || "serialVersionUID".equalsIgnoreCase(f.getName())) {
                    continue;
                }
                f.setAccessible(true);
                if (!withNullField && f.get(obj) == null) {
                    continue;
                }
                map.put(f.getName(), f.get(obj));
            }
            return map;
        }

        private void addValueToData0(String key, Object value) {
            if (this.data == null) {
                this.data = new HashMap<>(COLLECTION_DEFAULT_SIZE);
            }
            this.data.put(key, value);
        }

        private <T> void addListToData0(String key, List<T> list) {
            if (this.data == null) {
                this.data = new HashMap<>(COLLECTION_DEFAULT_SIZE);
            }
            if (list == null) {
                list = new ArrayList<>();
            }
            this.data.put(key, list);
        }
    }

    public static ApiResponse.ApiResponseBuilder builder() {
        return new ApiResponse.ApiResponseBuilder();
    }

    public ApiResponse addObjectToData(Object obj) throws Exception {
        this.addObjectToData0(null, obj, false, false);
        return this;
    }

    public ApiResponse addObjectToData(String key, Object obj) throws Exception {
        this.addObjectToData0(key, obj, false, false);
        return this;
    }

    public ApiResponse addObjectToData(String key, Object obj, boolean withNullField) throws Exception {
        this.addObjectToData0(key, obj, withNullField, false);
        return this;
    }

    public ApiResponse addObjectToData(String key, Object obj, boolean withNullField, boolean withName) throws Exception {
        this.addObjectToData0(key, obj, withNullField, withName);
        return this;
    }

    public ApiResponse addValueToData(String key, Object value) {
        this.addValueToData0(key, value);
        return this;
    }

    public <T> ApiResponse addListToData(List<T> list) {
        this.addListToData0("dataList", list);
        return this;
    }

    public <T> ApiResponse addListToData(String key, List<T> list) {
        this.addListToData0(key, list);
        return this;
    }

    private void addObjectToData0(String key, Object obj, boolean withNullField, boolean withName) throws Exception {
        if (this.data == null) {
            this.data = new HashMap<>(COLLECTION_DEFAULT_SIZE);
        }
        Map<String, Object> map = new ApiResponseBuilder().map(obj, withNullField);
        if (key != null) {
            this.data.put(key, map);
        } else {
            if (withName) {
                this.data.put(obj.getClass().getSimpleName().toLowerCase(), map);
            } else {
                this.data.putAll(map);
            }
        }
    }

    private void addValueToData0(String key, Object value) {
        if (this.data == null) {
            this.data = new HashMap<>(COLLECTION_DEFAULT_SIZE);
        }
        this.data.put(key, value);
    }

    private <T> void addListToData0(String key, List<T> list) {
        if (this.data == null) {
            this.data = new HashMap<>(COLLECTION_DEFAULT_SIZE);
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        this.data.put(key, list);
    }

}

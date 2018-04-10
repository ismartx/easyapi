package com.smartx.easyapi;

import com.smartx.easyapi.bean.api.ApiRequest;
import com.smartx.easyapi.bean.api.ApiResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * </p>
 *
 * <b>Creation Time:</b> 2018/4/2
 *
 * @author kext
 */
@RestController
@RequestMapping("/api/v1/test")
@Slf4j
public class TestController {

    @RequestMapping(value = "/say-hello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello";
    }

    @RequestMapping(value = "/test-json", method = RequestMethod.POST)
    public ApiResponse testJson(@RequestBody ApiRequest request) {
        log.info(request.getId());
        log.info(String.valueOf(request.getDataParamAsInteger("id")));
        log.info(String.valueOf(request.getUser().getUserId()));
        Bean bean = new Bean();
        bean.setName("kext2");
        try {
            return ApiResponse.builder()
                    .ok()
                    .addValueToData("name", "kext")
                    .addObjectToData(bean)
                    //.addObjectToData(bean, false)
                    //.addObjectToData(bean, true, false)
                    .build();
            /*
            ApiResponse response = new ApiResponse();
            response.setState(StateCode.SUCCESSFUL);
            return response
                    .addValueToData("name", "kext")
                    .addObjectToData(bean);
                    */
        } catch (Exception e) {
            log.error("Exception", e);
            return ApiResponse.builder().error().build();
        }
    }

}

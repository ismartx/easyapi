package com.smartx.easyapi;

import com.smartx.easyapi.bean.api.ApiResponse;
import com.smartx.easyapi.util.JsonUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <p>
 *
 * </p>
 *
 * <b>Creation Time:</b> 2018/4/1
 *
 * @author kext
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testSayHello() {
        String body = this.restTemplate.getForObject("/api/v1/test/say-hello", String.class);
        assertThat(body).isEqualTo("Hello");
    }

    @Test
    public void testJson() throws Exception {
        String request = "{\"id\":\"fe0082bb-03be-400f-aa1a-ba49dd8caf27\", \"timestamp\":123456, \"sign\":\"d3eeac030296b969c598ce736240a2cb\", \"data\":{\"id\":1}, \"user\":{\"userId\":123123}}}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(request, headers);
        String response = this.restTemplate.postForObject("/api/v1/test/test-json", entity, String.class);
        assertThat(response).isNotEqualTo(null);
        ApiResponse apiResponse = JsonUtil.json2Object(response, ApiResponse.class);
        //assertThat(apiResponse.getId()).isEqualTo("fe0082bb-03be-400f-aa1a-ba49dd8caf27");
        assertThat(apiResponse.getState().getCode()).isEqualTo(0);
        assertThat(apiResponse.getData().get("name")).isEqualTo("kext");
        assertThat(((Map) apiResponse.getData().get("bean")).get("name")).isEqualTo("kext2");
    }
}

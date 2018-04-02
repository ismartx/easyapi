package com.smartx.easyapi.bean.wrapper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.stream.Collectors;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * </p>
 *
 * <b>Creation Time:</b> 2017/11/15
 *
 * @author kext
 */
@Slf4j
public class RequestWrapper extends HttpServletRequestWrapper {

    private final byte[] body;

    public RequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        body = getBodyString(request).getBytes(Charset.forName("UTF-8"));
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {

        // 这里从body里面直接读了，没有去读inputStream了
        final ByteArrayInputStream bais = new ByteArrayInputStream(body);

        return new ServletInputStream() {

            @Override
            public int read() throws IOException {
                return bais.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }
        };
    }

    public String getBodyString() {
        return new String(this.body);
    }

    private String getBodyString(ServletRequest request) {
        try (InputStream inputStream = request.getInputStream()) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")))) {
                return reader.lines().collect(Collectors.joining());
            }
        } catch (IOException e) {
            log.warn("IOException", e);
        }
        return "";
    }
}

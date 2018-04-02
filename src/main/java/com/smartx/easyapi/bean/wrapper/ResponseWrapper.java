package com.smartx.easyapi.bean.wrapper;

import org.apache.commons.io.output.TeeOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * <p>
 *
 * </p>
 *
 * <b>Creation Time:</b> 2017/11/15
 *
 * @author kext
 */
public class ResponseWrapper extends HttpServletResponseWrapper {

    private ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private PrintWriter writer = new PrintWriter(bos);

    public ResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public ServletResponse getResponse() {
        return this;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return new ServletOutputStream() {
            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setWriteListener(WriteListener writeListener) {

            }

            private TeeOutputStream tee = new TeeOutputStream(ResponseWrapper.super.getOutputStream(), bos);

            @Override
            public void write(int b) throws IOException {
                tee.write(b);
            }
        };
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return new TeePrintWriter(super.getWriter(), writer);
    }

    public byte[] toByteArray() {
        return bos.toByteArray();
    }

    public String getBodyString() {
        return new String(this.toByteArray(), Charset.forName("UTF-8"));
    }
}

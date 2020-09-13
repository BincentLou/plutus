package com.david.freedom.plutus.mvc.filter;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @version $Id: null.java, v 1.0 2020/9/11 7:35 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class RequestReplaceWapper extends HttpServletRequestWrapper {

    private byte[] body;

    public byte[] getBody() {
        return body;
    }

    public RequestReplaceWapper setBody(byte[] body) {
        this.body = body;
        return this;
    }

    public RequestReplaceWapper(HttpServletRequest request, String content){
        super(request);
        body = content.getBytes(StandardCharsets.UTF_8);
    }


    @Override
    public BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }



    @Override
    public ServletInputStream getInputStream(){
        final ByteArrayInputStream bais = new ByteArrayInputStream(body);

        return new ServletInputStream() {

            @Override
            public int read() {
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


}

package com.david.freedom.plutus.mvc.filter;

import com.david.freedom.plutus.decode.RSA2048Util;
import org.springframework.boot.json.JacksonJsonParser;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * @version $Id: null.java, v 1.0 2020/9/11 7:41 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class DecodeAndHttpServletRequestReplacedFilter implements Filter {

    private final static String PH_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDuHNogiiX9O/G6ApfP4MRuOpewVhF8SGq/N7f67LtUvcumpS6qm/N2nGGOl9fKgQe34XhnrcAKv6iS3PT7apLqNoKp2Lx1v+sUMQgPWQSRGNJHMwMJTKEOdyBxFix3NQY36oVqFPV09JS8RG3lW3duhw2W9choDfi5vxfh2pmRrS/ul3atoYykJdDMARsRWih3lUwMCkY2PW9FlnVmz1+mrwau6uXoVylOvqP9mOhVbk24PTozlpox1BjFQt3SPU2JzyoYyzP9jykFQGstd7puWQ2xqS4e+dTQ9WMQz6DAD6k5at8qbzVrAQNSlJ0N+LH+p+U8u0loUmnavJI4VZ+/AgMBAAECggEAb1OcBFSy2Egbh31I309WZ7cLTs2e1T3Ccu6pHS9rkn4+Zgaa3/eUB+OrlRCXOr3DDwziz46j2CKtvSSDgbzdPZYI10JXMrJtRX57JznWccRqJBHMnJ9wOaQmzdixJ3bqFmCWyfdMn8bud2uC+hYeq9WG3ArEDSpjHO0kTFt5K2snsqf/MnLF8aCrbv3+zpxaoOvvzmnoC6/IonV85/RADR7+CQDsPmBKfhIsM7Lis0gVRPUjLMFpVYgFwp2ZHKiGa51v+nWjWTJI6SXJnXY1oK8LTluCrqhejXNReSKSLzvZ/wBvjz9T5bBk5JG2stjP8V1jqkwsz0J9YeiqmT2XEQKBgQD7d+Q0+gwyZMeLjLsedDEquz7Smim9gVN3gdxdXd4VgfO1JZzy2yLciVKRgtku9o4RlSiC8FOMVqXnvDxeF9fS6uR7JEtazx3WUVJ9bCpOpJmAeTjP2JKZ/axprmRqaOxUINPQHM4XQzrlMBBFDyePBwAGcy29FnNHWcdaQD19GQKBgQDyZ1i7wNniQrjE9jT4PUD50KKhfrIegO6CmlgwZvmHBZ41gYbJAfRJTyu84IjyUvJxnarzfDQXA3biZxj/sDkn8LhOqIYdt6YIX/DhRVoPput00AwI7/9NbLbKYF8afK8sZqVB3rFkSz77ZVNMeCqaDBJ4GdGqADesfRSyAjxGlwKBgQCYkYsBoVvZD1AKGN5GgdR6ypQ5DpOYiGhtr3pVo2fkwK1uEF4C8nVaPG6+HhdK6QgVHtwvZUQrdz69NHWj2O925lCtbb3SYKsHpttXgVLB2BfR3LpdUFbR2xjKHaaK8RHBkRExyOg5MO8AsoKMg79KhcK8JxFvEbnrZksPNL6ZsQKBgQDCvty/GtTxvoELXHJ57VxCV6gQ7uTTNOpp6u5nFJPsMktE2WccHoHQU9bjy9C6PoGhXfZ135dJ1fKxOfsPkNiaif7I0wPM5Dp0CABSO5F7ebM5CdxhYc9OuMSyGnLNqNZjaaPjI7KIzRswhdtCWFiBoqlD7BpR5hLUdTknOjyKyQKBgQC6exfkz5VNZCGZkhLtnCT0SnLMtnOGUS07EWdxViJVjYIh3PfDJwxSoZzPh8Hy58gmYX9ogM60F6WLna2PUb4oEFLxP7IUHf68vweBxygBs/nPtV+tuayRcH31XDqSblwwrpcfLOub605JNf7UEMNkFSKtu1nsNi6+90qjTWFacA==";

    private final static String PH_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7hzaIIol/TvxugKXz+DEbjqXsFYRfEhqvze3+uy7VL3LpqUuqpvzdpxhjpfXyoEHt+F4Z63ACr+oktz0+2qS6jaCqdi8db/rFDEID1kEkRjSRzMDCUyhDncgcRYsdzUGN+qFahT1dPSUvERt5Vt3bocNlvXIaA34ub8X4dqZka0v7pd2raGMpCXQzAEbEVood5VMDApGNj1vRZZ1Zs9fpq8Grurl6FcpTr6j/ZjoVW5NuD06M5aaMdQYxULd0j1Nic8qGMsz/Y8pBUBrLXe6blkNsakuHvnU0PVjEM+gwA+pOWrfKm81awEDUpSdDfix/qflPLtJaFJp2rySOFWfvwIDAQAB";

    JacksonJsonParser jacksonParser = new JacksonJsonParser();

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        ServletRequest requestWrapper = null;
        if(servletRequest instanceof HttpServletRequest) {
            String content = RequestInputStreamUtil.getBodyString((HttpServletRequest) servletRequest);


            Map<String, Object> map = jacksonParser.parseMap(content);
            String params = (String) map.get("param");
            //TODO 解密
            String trueParams = RSA2048Util.rsaDecipher(params, PH_PRIVATE_KEY);
            System.out.println(trueParams);

            requestWrapper = new RequestReplaceWapper((HttpServletRequest) servletRequest,"{\"registrationStatusEnum\":\"正常\",\"telephone\":\"12345677654\",\"cretNo\":\"234576543456\",\"userName\":\"louwb\"}");
        }

        //获取请求中的流如何，将取出来的字符串，再次转换成流，然后把它放入到新request对象中。
        // 在chain.doFiler方法中传递新的request对象
        if(requestWrapper == null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(requestWrapper, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}

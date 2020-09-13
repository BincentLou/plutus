package com.david.freedom.plutus.facade;

import com.david.freedom.plutus.request.ThridPathRequest;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version $Id: null.java, v 1.0 2020/9/13 10:49 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:加密消息请求路径
 * @since 1.0
 **/
public interface EncodedFacade {

    @RequestMapping("/encodedRequest")
    void encodedRequest(ThridPathRequest thridPathRequest);

    @RequestMapping("/anotherEncodedRequest")
    void anotherEncodedRequest(ThridPathRequest thridPathRequest);
}

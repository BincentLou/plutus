package com.david.freedom.plutus.web;

import com.david.freedom.plutus.facade.EncodedFacade;
import com.david.freedom.plutus.request.ThridPathRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version $Id: null.java, v 1.0 2020/9/13 11:06 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@RestController
public class EncodedController implements EncodedFacade {


    @Override
    public void encodedRequest(@RequestBody @Validated ThridPathRequest thridPathRequest) {
        System.out.println(thridPathRequest);
    }

    @Override
    public void anotherEncodedRequest(@RequestBody @Validated ThridPathRequest thridPathRequest) {
        System.out.println("呵呵"+thridPathRequest);

    }
}

package com.david.freedom.plutus.biz.scheduled;

import com.david.freedom.plutus.biz.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @version $Id: null.java, v 1.0 2020/9/4 10:45 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:定时任务
 * @since 1.0
 **/
@Service
public class BackUpScheduled {

    @Autowired
    RegistrationService registrationService;

    @Scheduled(cron = "59 * * * * ?")
    public void backUpRegistrationInfo(){
        registrationService.backUpRegistrationInfo();
    }
}

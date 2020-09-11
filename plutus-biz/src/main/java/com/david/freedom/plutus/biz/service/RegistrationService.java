package com.david.freedom.plutus.biz.service;

import com.david.freedom.plutus.biz.utils.RegistrationInfoExcelEntity;
import com.david.freedom.plutus.request.AddRegistratioInfoRequest;

import java.util.List;

/**
 * @version $Id: null.java, v 1.0 2020/9/3 8:57 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: 注册信息操作服务类
 * @since 1.0
 **/
public interface RegistrationService {

    /**
     * 新增登记信息
     * @param registratioInfoRequest
     */
    Integer addRegistrationInfo(AddRegistratioInfoRequest registratioInfoRequest);

    /**
     * 备份数据
     */
    void backUpRegistrationInfo();

    /**
     * 查询需要备份的信息
     * @return
     */
    List<RegistrationInfoExcelEntity> selectAllBackUpInfos();
}

package com.david.freedom.plutus.facade;

import com.david.freedom.plutus.common.response.BaseResponse;
import com.david.freedom.plutus.request.AddRegistratioInfoRequest;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @version $Id: null.java, v 1.0 2020/9/3 8:31 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:录入信息的接口
 * @since 1.0
 **/
public interface RegistrationFacade{

    /**
     * 新增登记信息
     * @param registratioInfoRequest
     * @return
     */
    @RequestMapping("/addRegistrationInfo")
    BaseResponse<Integer> addRegistrationInfo(AddRegistratioInfoRequest registratioInfoRequest);

    /**
     * 导出登记信息
     * @param
     * @return
     */
    @RequestMapping("/exportExcel")
    void exportExcel(HttpServletResponse response);



}

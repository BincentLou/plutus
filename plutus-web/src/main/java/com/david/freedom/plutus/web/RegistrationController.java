package com.david.freedom.plutus.web;

import com.david.freedom.plutus.biz.service.RegistrationService;
import com.david.freedom.plutus.biz.utils.ExcelUtils;
import com.david.freedom.plutus.biz.utils.RegistrationInfoExcelEntity;
import com.david.freedom.plutus.common.response.BaseResponse;
import com.david.freedom.plutus.facade.RegistrationFacade;
import com.david.freedom.plutus.request.AddRegistratioInfoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @version $Id: null.java, v 1.0 2020/9/3 8:51 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:控制器
 * @since 1.0
 **/
@RestController
public class RegistrationController  extends BaseController implements RegistrationFacade{

    @Autowired
    private RegistrationService registrationService;

    @Override
    public BaseResponse<Integer> addRegistrationInfo(@Validated @RequestBody AddRegistratioInfoRequest registratioInfoRequest) {

        return new BaseResponse<>(registrationService.addRegistrationInfo(registratioInfoRequest));

    }

    @Override
    public void exportExcel(HttpServletResponse response) {

        List<RegistrationInfoExcelEntity> infos = registrationService.selectAllBackUpInfos();

        ExcelUtils.writeExcel(response,infos,RegistrationInfoExcelEntity.class);

    }
}

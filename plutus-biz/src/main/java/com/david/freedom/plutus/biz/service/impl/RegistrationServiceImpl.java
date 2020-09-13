package com.david.freedom.plutus.biz.service.impl;

import com.david.freedom.plutus.biz.service.RegistrationService;
import com.david.freedom.plutus.biz.utils.ExcelUtils;
import com.david.freedom.plutus.biz.utils.RegistrationInfoExcelEntity;
import com.david.freedom.plutus.common.utils.ConvertUtils;
import com.david.freedom.plutus.dao.RegistrationInfoMapper;
import com.david.freedom.plutus.entity.RegistrationInfo;
import com.david.freedom.plutus.entity.RegistrationInfoExample;
import com.david.freedom.plutus.request.AddRegistratioInfoRequest;
import com.david.freedom.plutus.stats.RegistrationStatusEnum;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @version $Id: null.java, v 1.0 2020/9/3 8:58 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:实现类
 * @since 1.0
 **/
@Service
public class RegistrationServiceImpl implements RegistrationService {


    @Resource
    RegistrationInfoMapper registrationInfoMapper;

    @Override
    public Integer addRegistrationInfo(AddRegistratioInfoRequest registratioInfoRequest) {
        RegistrationInfo record = new RegistrationInfo();
        record.setCertNo(registratioInfoRequest.getCretNo());
        record.setTelNo(registratioInfoRequest.getTelephone());
        record.setUserName(registratioInfoRequest.getUserName());
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        record.setStatus(Short.parseShort("1"));
        insert2(registratioInfoRequest);
        return registrationInfoMapper.insert(record);

    }

    private void insert2(AddRegistratioInfoRequest registratioInfoRequest) {

        throw new IllegalArgumentException("insert2方法发生了异常");
    }

    @Override
    public void backUpRegistrationInfo() {
        List<RegistrationInfoExcelEntity> excelInfos = selectAllBackUpInfos();
        ExcelUtils.buildExcel(excelInfos,RegistrationInfoExcelEntity.class);
    }

    @Override
    public List<RegistrationInfoExcelEntity> selectAllBackUpInfos() {
        RegistrationInfoExample example = new RegistrationInfoExample();
        example.createCriteria().andStatusEqualTo(Short.decode(RegistrationStatusEnum.NORMAL.getKey()));
        List<RegistrationInfo> registrationInfos = registrationInfoMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(registrationInfos)){
            return Collections.EMPTY_LIST;
        }
        List<RegistrationInfoExcelEntity> excelInfos = new ArrayList<>(registrationInfos.size());
        registrationInfos.forEach(registrationInfo -> {
            RegistrationInfoExcelEntity excelEntiry = new RegistrationInfoExcelEntity();
            ConvertUtils.convert(registrationInfo,excelEntiry);
            excelInfos.add(excelEntiry);
        });
        return excelInfos;
    }


}

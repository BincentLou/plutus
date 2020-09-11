package com.david.freedom.plutus.biz.utils;

import com.david.freedom.plutus.biz.utils.anno.ExcelColumn;

import java.util.Date;

/**
 * @version $Id: null.java, v 1.0 2020/9/4 11:26 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:导出登记信息实体类
 * @since 1.0
 **/
public class RegistrationInfoExcelEntity {


    /** 主键id */
    @ExcelColumn(value = "id", col = 1)
    private Long id;

    /** 姓名 */
    @ExcelColumn(value = "姓名", col = 2)
    private String userName;

    /** 身份证 */
    @ExcelColumn(value = "身份证", col = 3)
    private String certNo;

    /** 电话号码 */
    @ExcelColumn(value = "电话号码", col = 4)
    private String telNo;

    /** 创建时间 */
    @ExcelColumn(value = "登记时间", col = 5)
    private Date createTime;

    public Long getId() {
        return id;
    }

    public RegistrationInfoExcelEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public RegistrationInfoExcelEntity setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getCertNo() {
        return certNo;
    }

    public RegistrationInfoExcelEntity setCertNo(String certNo) {
        this.certNo = certNo;
        return this;
    }

    public String getTelNo() {
        return telNo;
    }

    public RegistrationInfoExcelEntity setTelNo(String telNo) {
        this.telNo = telNo;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public RegistrationInfoExcelEntity setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
}

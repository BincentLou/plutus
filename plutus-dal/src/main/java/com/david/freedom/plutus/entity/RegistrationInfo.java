/**
 * hsjry.com Inc.
 * Copyright (c) 2015-2020 All Rights Reserved.
 */
package com.david.freedom.plutus.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hsjry
 * @version $Id: RegistrationInfo.java, v1.0 2020年09月04日 10:47:16 hsjry Exp $
 * @since 1.0
 */
public class RegistrationInfo implements Serializable {
    /** 主键id */
    private Long id;

    /** 姓名 */
    private String userName;

    /** 身份证 */
    private String certNo;

    /** 电话号码 */
    private String telNo;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;

    /** 状态 */
    private Short status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table registration_info
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column registration_info.id
     *
     * @return the value of registration_info.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column registration_info.id
     *
     * @param id the value for registration_info.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column registration_info.user_name
     *
     * @return the value of registration_info.user_name
     *
     * @mbg.generated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column registration_info.user_name
     *
     * @param userName the value for registration_info.user_name
     *
     * @mbg.generated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column registration_info.cert_no
     *
     * @return the value of registration_info.cert_no
     *
     * @mbg.generated
     */
    public String getCertNo() {
        return certNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column registration_info.cert_no
     *
     * @param certNo the value for registration_info.cert_no
     *
     * @mbg.generated
     */
    public void setCertNo(String certNo) {
        this.certNo = certNo == null ? null : certNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column registration_info.tel_no
     *
     * @return the value of registration_info.tel_no
     *
     * @mbg.generated
     */
    public String getTelNo() {
        return telNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column registration_info.tel_no
     *
     * @param telNo the value for registration_info.tel_no
     *
     * @mbg.generated
     */
    public void setTelNo(String telNo) {
        this.telNo = telNo == null ? null : telNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column registration_info.create_time
     *
     * @return the value of registration_info.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column registration_info.create_time
     *
     * @param createTime the value for registration_info.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column registration_info.update_time
     *
     * @return the value of registration_info.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column registration_info.update_time
     *
     * @param updateTime the value for registration_info.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column registration_info.STATUS
     *
     * @return the value of registration_info.STATUS
     *
     * @mbg.generated
     */
    public Short getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column registration_info.STATUS
     *
     * @param status the value for registration_info.STATUS
     *
     * @mbg.generated
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table registration_info
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        RegistrationInfo other = (RegistrationInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getCertNo() == null ? other.getCertNo() == null : this.getCertNo().equals(other.getCertNo()))
            && (this.getTelNo() == null ? other.getTelNo() == null : this.getTelNo().equals(other.getTelNo()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table registration_info
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getCertNo() == null) ? 0 : getCertNo().hashCode());
        result = prime * result + ((getTelNo() == null) ? 0 : getTelNo().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table registration_info
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", certNo=").append(certNo);
        sb.append(", telNo=").append(telNo);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
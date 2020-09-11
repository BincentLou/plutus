package com.david.freedom.plutus.common.response;

import java.io.Serializable;

/**
 * @version $Id: null.java, v 1.0 2020/9/3 8:46 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:基本返回类型
 * @since 1.0
 **/
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 3405687718018116362L;

    /**
     * 业务返回
     */
    private T data;

    /**
     * 成功标识位
     */
    private Boolean success;

    /**
     * 错误提示
     */
    private String errMsg;

    /**
     * 错误编码
     */
    private String errCode;

    public BaseResponse() {
    }

    public BaseResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public BaseResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public BaseResponse<T> setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public BaseResponse<T> setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }

    public String getErrCode() {
        return errCode;
    }

    public BaseResponse<T> setErrCode(String errCode) {
        this.errCode = errCode;
        return this;
    }
}

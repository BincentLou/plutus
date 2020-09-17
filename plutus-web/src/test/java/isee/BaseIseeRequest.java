package isee;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @version $Id: null.java, v 1.0 2020/9/16 4:05 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:请求基本类
 * @since 1.0
 **/
@Data
public class BaseIseeRequest implements Serializable {

    private static final long serialVersionUID = 7735177038428158040L;

    /**
     * 回溯码
     */
    @NotNull(message = "回溯码不能为空")
    private String iseeBiz;

    /**
     * 机构代码
     */
    @NotNull(message = "机构代码不能为空")
    private String orgNo;

    /**
     * 产品名称
     */
    @NotNull(message = "产品名称不能为空")
    private String campaignName;

    /**
     * 核保时间
     */
    @NotNull(message = "核保时间不能为空")
    private Date applyTime;

    /**
     * 承保时间
     */
    @NotNull(message = "承保事件不能为空")
    private Date underwritingTime;

    /**
     * 订单号
     */
    @NotNull(message = "订单号不能为空")
    private String orderNo ;

    /**
     * 客户信息
     */
    @NotNull(message = "客户信息不能为空")
    private Customer[] customer;

    @Data
    class Customer implements Serializable{

        private static final long serialVersionUID = 4515560154722024710L;
        /**
         * 客户类型
         */
        private Integer customType;

        /**
         * 客户姓名
         */
        private String customName;

        /**
         * 客户证件类
         * {@link EnumIseeCretificateKind}
         */
        private Integer customIdType;

        /**
         * 客户证件号
         */
        private String customIdNo;

        /**
         * 客户手机号
         */
        private Integer customMobile;


    }
}

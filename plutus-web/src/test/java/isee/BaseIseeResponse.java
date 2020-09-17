package isee;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
 * @version $Id: null.java, v 1.0 2020/9/16 4:18 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:千里眼调用回调
 * @since 1.0
 **/
@Data
@Builder
public class BaseIseeResponse<T> implements Serializable {

    /**
     * 成功
     */
    public static final Integer SUCCESS = 0;
    /**
     * 验签失败
     */
    public static final Integer UNSIGN_FAIL = 1000;


    private static final long serialVersionUID = -4544849331434802044L;

    /**
     * 公司 ID
     */
    private String companyId;

    /**
     * 流水号
     */
    private String UUID;

    /**
     * 发送时间
     */
    private Date sendTime;

    /**
     * 返回码
     */
    private Integer responseCode;

    /**
     * 错误消息
     */
    private String responseMsg;

    /**
     * 错误消息
     */
    private T response;


}

package com.david.freedom.plutus.web;

import com.david.freedom.plutus.stats.RegistrationStatusEnum;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

/**
 * @version $Id: null.java, v 1.0 2020/9/8 10:54 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
//@ControllerAdvice
public class BaseController {

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(RegistrationStatusEnum.class,new String2EnumEditor());
    }

    private class String2EnumEditor extends PropertyEditorSupport implements PropertyEditor {

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            // 2. 将 String 类型转换成 Properties 类型
            RegistrationStatusEnum tar = RegistrationStatusEnum.localByDesc(text);

            // 3. 临时存储 Properties 对象
            setValue(tar);
        }
    }
}

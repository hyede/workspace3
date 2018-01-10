package com.yede.security.core.validate.code.sms;

import com.yede.security.core.properties.SecurityProperties;
import com.yede.security.core.validate.code.ValidateCode;
import com.yede.security.core.validate.code.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by yede on 2018/1/10.
 */
@Component("smsValidateCodeGenerator")
public class SmsValidateCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
    @Override
    public ValidateCode generate(ServletWebRequest request) {
       String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidateCode(code,securityProperties.getCode().getSms().getExpireIn());
    }
}

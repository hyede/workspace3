package com.yede.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by yede on 2018/1/10.
 */
public interface ValidateCodeGenerator {
    ValidateCode generate(ServletWebRequest request);
}

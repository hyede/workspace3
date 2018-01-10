package com.yede.security.core.validate.code.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yede on 2018/1/10.
 */
public class DefaultSmsSendCode implements SmsCodeSender {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void send(String mobile, String code) {
        logger.info("默认发送短信" + mobile + "----" + code);
    }
}

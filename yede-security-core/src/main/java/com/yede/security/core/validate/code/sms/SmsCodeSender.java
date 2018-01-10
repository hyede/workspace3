package com.yede.security.core.validate.code.sms;

/**
 * Created by yede on 2018/1/10.
 */
public interface SmsCodeSender {
    void send(String mobile,String code);
}

package com.ravan.starter.template;

import com.ravan.starter.enums.SmsTypeEnum;
import com.ravan.starter.exception.InvalidSmsTypeException;
import com.ravan.starter.properties.ExternalSmsProperties;
import com.ravan.starter.service.SmsService;

import java.util.Map;

public class SmsTemplate {

    private final ExternalSmsProperties smsProperties;
    private final Map<String, SmsService> services;

    public SmsTemplate(ExternalSmsProperties smsProperties, Map<String, SmsService> services) {
        this.smsProperties = smsProperties;
        this.services = services;
    }

    public String sendSms(String fromPhone,String toPhone,String content){
        String type = smsProperties.getType();
        SmsService smsService = services.get(type);
        if (smsService == null) {
           // logger.error("Invalid SMS type: {}", type);
            throw new InvalidSmsTypeException("Invalid SMS type: " + type, type);
        }
        return smsService.send(fromPhone,toPhone,content);
    }

}

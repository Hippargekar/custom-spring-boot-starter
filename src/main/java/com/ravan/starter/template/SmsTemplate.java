package com.ravan.starter.template;

import com.ravan.starter.dto.SmsMessage;
import com.ravan.starter.exception.InvalidSmsTypeException;
import com.ravan.starter.properties.ExternalSmsProperties;
import com.ravan.starter.service.SmsService;

import java.util.Map;

public class SmsTemplate {

    private final ExternalSmsProperties smsProperties;
    private final Map<String, SmsService> services;

    public SmsTemplate(ExternalSmsProperties smsProperties, Map<String, SmsService> services){
        this.smsProperties = smsProperties;
        this.services = services;
    }

    public String sendSms(SmsMessage smsMessage){
        String type = smsProperties.getType();
        SmsService smsService = services.get(type);
        if (smsService == null) {
            throw new InvalidSmsTypeException("Invalid SMS type: " + type, type);
        }
        return smsService.sendSms(smsMessage);
    }

}

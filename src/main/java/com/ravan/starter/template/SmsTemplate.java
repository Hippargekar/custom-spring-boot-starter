package com.ravan.starter.template;

import com.ravan.starter.enums.SmsTypeEnum;
import com.ravan.starter.exception.InvalidSmsTypeException;
import com.ravan.starter.properties.ExternalSmsProperties;
import com.ravan.starter.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component  // Register as a Spring-managed bean
public class SmsTemplate {
    private final ExternalSmsProperties smsProperties;
    private final ApplicationContext context;

    @Autowired
    public SmsTemplate(ExternalSmsProperties smsProperties, ApplicationContext context) {
        this.smsProperties = smsProperties;
        this.context = context;
    }

    public String sendSms(String fromPhone,String toPhone,String content){
        String type = smsProperties.getType();
        if (!SmsTypeEnum.isValid(type)) {
            throw new InvalidSmsTypeException("Invalid SMS type: " + type, type);
        }
        SmsService smsService = (SmsService)context.getBean(type);
        return smsService.send(fromPhone,toPhone,content);
    }

}

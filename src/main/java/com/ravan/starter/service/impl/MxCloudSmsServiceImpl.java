package com.ravan.starter.service.impl;

import com.ravan.starter.dto.SmsMessage;
import com.ravan.starter.service.SmsService;
import org.springframework.stereotype.Service;

@Service("mx")
public class MxCloudSmsServiceImpl implements SmsService {
    @Override
    public String sendSms(SmsMessage smsMessage) {
        return "MxCloudSmsServiceImpl";
    }
}

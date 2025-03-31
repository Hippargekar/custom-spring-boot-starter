package com.ravan.starter.service.impl;

import com.ravan.starter.dto.SmsMessage;
import com.ravan.starter.service.SmsService;
import org.springframework.stereotype.Service;

@Service("tx")
public class TxCloudSmsServiceImpl implements SmsService {
    @Override
    public String sendSms(SmsMessage smsMessage) {
        return "TxCloudSmsServiceImpl";
    }
}

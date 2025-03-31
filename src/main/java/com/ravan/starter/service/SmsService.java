package com.ravan.starter.service;

import com.ravan.starter.dto.SmsMessage;

public interface SmsService {
    String sendSms(SmsMessage smsMessage);
}

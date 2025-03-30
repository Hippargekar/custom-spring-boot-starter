package com.ravan.starter.service.impl;

import com.ravan.starter.service.SmsService;
import org.springframework.stereotype.Service;

@Service("tx")
public class TxCloudSmsServiceImpl implements SmsService {
    @Override
    public String send(String fromPhone, String toPhone, String content) {
        return "TxCloudSmsServiceImpl";
    }
}

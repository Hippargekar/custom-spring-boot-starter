package com.ravan.starter.service.impl;

import com.ravan.starter.service.SmsService;
import org.springframework.stereotype.Service;

@Service("ax")
public class AxCloudSmsServiceImpl implements SmsService {

    @Override
    public String send(String fromPhone, String toPhone, String content) {
        return "AxCloudSmsServiceImpl";
    }
}

package com.ravan.starter.properties;

//import com.ravan.starter.enums.SmsTypeEnum;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "starter.sms")//starter.sms.type=
@Component
public class ExternalSmsProperties {
    private String type;

    public String getType() {
//        if(type == null || "".equals(type)){
//            type = SmsTypeEnum.AX_CLOUD.getType(); // Fallback to default if null
//        }
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

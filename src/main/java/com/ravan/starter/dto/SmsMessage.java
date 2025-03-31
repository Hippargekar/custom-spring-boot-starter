package com.ravan.starter.dto;

public class SmsMessage {
    private String fromPhone;
    private String toPhone;
    private String content;

    public String getFromPhone() {
        return fromPhone;
    }

    public void setFromPhone(String fromPhone) {
        this.fromPhone = fromPhone;
    }

    public String getToPhone() {
        return toPhone;
    }

    public void setToPhone(String toPhone) {
        this.toPhone = toPhone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "SmsMessage{" +
                "fromPhone='" + fromPhone + '\'' +
                ", toPhone='" + toPhone + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

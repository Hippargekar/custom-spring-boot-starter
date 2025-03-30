package com.ravan.starter.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum SmsTypeEnum {
    AX_CLOUD("ax"),
    TX_CLOUD("tx"),
    MX_CLOUD("mx");

    private final String type;

    SmsTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static boolean isValid(String type) {
        return Arrays.stream(values())
                .anyMatch(t -> t.getType().equals(type));
    }

    public static String getAllTypes() {
        return Arrays.stream(values())
                .map(SmsTypeEnum::getType)
                .collect(Collectors.joining(","));
    }

}

package com.ravan.starter.exception;

import com.ravan.starter.enums.SmsTypeEnum;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

public class InvalidSmsTypeFailureAnalyzer extends AbstractFailureAnalyzer<InvalidSmsTypeException> {

    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, InvalidSmsTypeException cause) {
        return new FailureAnalysis(String.format("The SMS service could not be auto-configured properly: '%s' is an invalid SMS type.", cause.getType()),
                String.format("A valid SMS type must be one of the following: '%s'", SmsTypeEnum.getAllTypes()), cause);
    }
}

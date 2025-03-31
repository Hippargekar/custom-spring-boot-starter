package com.ravan.starter;

import com.ravan.starter.exception.InvalidSmsTypeException;
import com.ravan.starter.properties.ExternalSmsProperties;
import com.ravan.starter.service.SmsService;
import com.ravan.starter.template.SmsTemplate;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.Map;

//@SpringBootApplication
//public class CustomStarterApplication {
//	public static void main(String[] args) {
//		SpringApplication.run(CustomStarterApplication.class, args);
//	}
//

@AutoConfiguration
@ConditionalOnClass(SmsTemplate.class)
@EnableConfigurationProperties(value = ExternalSmsProperties.class)
public class CustomStarterConfiguration {

	@Autowired
	private ExternalSmsProperties smsProperties;
	@Autowired
	private Map<String, SmsService> services;

//	private final ExternalSmsProperties smsProperties;
//	private final Map<String, SmsService> services;
//	public CustomStarterConfiguration(ExternalSmsProperties smsProperties, Map<String, SmsService> services) {
//		this.smsProperties = smsProperties;
//		this.services = services;
//	}

	@Bean
	@ConditionalOnMissingBean
	public SmsTemplate smsTemplate() {
		String type = smsProperties.getType();
		SmsService smsService = services.get(type);
		if (smsService == null) {
			throw new InvalidSmsTypeException("Invalid SMS type: " + type, type);
		}
		return new SmsTemplate(smsProperties, services);
	}
}

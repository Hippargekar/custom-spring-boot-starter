package com.ravan.starter;

import com.ravan.starter.enums.SmsTypeEnum;
import com.ravan.starter.exception.InvalidSmsTypeException;
import com.ravan.starter.properties.ExternalSmsProperties;
import com.ravan.starter.template.SmsTemplate;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

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

	@Bean
	@ConditionalOnMissingBean
	public SmsTemplate smsTemplate(ExternalSmsProperties smsProperties, ApplicationContext context) {
		String type = smsProperties.getType();
		if (!SmsTypeEnum.isValid(type)) {
			throw new InvalidSmsTypeException("Invalid SMS type: " + type, type);
		}
		return new SmsTemplate(smsProperties, context);
	}
}

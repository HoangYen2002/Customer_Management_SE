package com.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc 
@ComponentScan(basePackages = { "com.*" })
public abstract class WebMvcConfig implements WebMvcConfigurer {

	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource  = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasename("classpath:messages");
	    messageSource.setDefaultEncoding("UTF-8");
		    return messageSource;
		}
		
	@Bean
	public LocalValidatorFactoryBean getValidator() {
	    LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
	    localValidatorFactoryBean.setValidationMessageSource(messageSource());
	    return localValidatorFactoryBean;
	}
	
}
package com.product;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
@Configuration
public class ResoueceConfig implements WebMvcConfigurer{
	@Bean(name = "messageSource")
    public MessageSource getMessageResource()  {
        ReloadableResourceBundleMessageSource messageResource= new ReloadableResourceBundleMessageSource();
        messageResource.setBasenames("classpath:static/i18n/messages/accountMessage","classpath:static/i18n/messages/layout");
        messageResource.setDefaultEncoding("utf-8");
        return messageResource;
    }
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor inter = new LocaleChangeInterceptor();
		inter.setParamName("lang");
		
		registry.addInterceptor(inter).addPathPatterns("home/language");
	}
	@Bean(name = "localeResolver")
    public LocaleResolver getLocaleResolver()  {
		//SessionLocaleResolver dung session
        CookieLocaleResolver resolver= new CookieLocaleResolver();
        resolver.setCookiePath("/");
        resolver.setCookieMaxAge(2*60*60); //dung cookie de luu bao lau tai soa khong dung session vi kia dong thi no xem mat
        resolver.setDefaultLocale(new Locale("en")); 
        return resolver;
    } 
	
	
}

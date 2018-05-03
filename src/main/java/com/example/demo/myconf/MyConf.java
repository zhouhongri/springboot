package com.example.demo.myconf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.example.demo.controller.ServletTest;
import com.example.demo.filter.TimerFilter;
import com.example.demo.handleinterceptor.TimeInterceptor;

@Configuration
public class MyConf implements WebMvcConfigurer {
	// 自定义servlet
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new ServletTest(), "/servletTest");
	}

	// 自定义过滤器
	@Bean
	public FilterRegistrationBean timeFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		TimerFilter tf = new TimerFilter();
		filterRegistrationBean.setFilter(tf);
		List<String> urllist = new ArrayList<String>();
		urllist.add("/*");
		filterRegistrationBean.setUrlPatterns(urllist);
		return filterRegistrationBean;
	}

	// 自定义拦截器
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new TimeInterceptor());
	}
	@Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        
        HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
        
        return new HttpMessageConverters(converter);

    }
}

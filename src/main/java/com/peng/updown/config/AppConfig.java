package com.peng.updown.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * 相当于updown-servlet.xml
 * @author peng
 *
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.peng.updown") //相当于扫描包
public class AppConfig {
	
	/**
	 * 视图解析器
	 * @return
	 */
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Bean
	public MultipartResolver multipartResolver(){
		CommonsMultipartResolver mult = new CommonsMultipartResolver();
		return mult;
	}

}

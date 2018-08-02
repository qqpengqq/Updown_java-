
@Bean
	public MultipartResolver multipartResolver(){
		CommonsMultipartResolver mult = new CommonsMultipartResolver();
		return mult;
	}
	
	相当于xxx-servlet.xml中的配置
	<bean id="multipartResolver"
        class="org.springframework.web.multipart.commons.CommonsMultipartResolver" />
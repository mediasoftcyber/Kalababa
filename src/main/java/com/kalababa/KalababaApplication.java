package com.kalababa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.kalababa.config.SecurityConfig;

@SpringBootApplication
@Import({SecurityConfig.class})
@ImportResource(locations = {"classpath:com/kalababa/config/applicationContext.xml"})
public class KalababaApplication /*implements WebMvcConfigurer*/ {
	
	/*@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resource/");
	}*/

	public static void main(String[] args) {
		SpringApplication.run(KalababaApplication.class, args);
	}

}

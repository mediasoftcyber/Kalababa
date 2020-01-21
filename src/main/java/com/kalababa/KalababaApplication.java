package com.kalababa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.kalababa.config.CustomEditorConfig;
import com.kalababa.config.SecurityConfig;
import com.kalababa.config.WebFlowConfig;

@SpringBootApplication
@Import({SecurityConfig.class, CustomEditorConfig.class, WebFlowConfig.class})
//@ImportResource(locations = {"classpath:com/kalababa/config/applicationContext.xml"})
public class KalababaApplication  {


	public static void main(String[] args) {
		SpringApplication.run(KalababaApplication.class, args);
	}

}

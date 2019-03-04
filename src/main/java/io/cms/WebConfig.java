package io.cms;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 
 * @author Vitor Correa
 * @date 26 Feb 2019
 */

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurationSupport {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}

}

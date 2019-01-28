package com.invillia.acme.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

	
	private static final int CACHE_PERIOD = 31556926; // one year

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("/images/").setCachePeriod(CACHE_PERIOD);
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(CACHE_PERIOD);
		registry.addResourceHandler("/js/**/*.js/**").addResourceLocations("/css/").setCachePeriod(CACHE_PERIOD);
		registry.addResourceHandler("/css/**/*.css/**").addResourceLocations("/js/").setCachePeriod(CACHE_PERIOD);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/login").setViewName("login");
	}

	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // Serving static files using the Servlet container's default Servlet.
        configurer.enable();
	}
	
	@Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
        // add your custom formatters
	}

}
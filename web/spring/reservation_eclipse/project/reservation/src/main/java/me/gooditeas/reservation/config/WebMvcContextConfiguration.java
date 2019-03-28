package me.gooditeas.reservation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 
 * Dispatcher Servlet
 * 
 * Component Scan
 * - Controller
 * - RestController 
 * 
 * */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"me.gooditeas.reservation.controller.*"})
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter{
	/* addResourceHandlers 
	 * Add handlers to serve static resources such as images, js, and, css files from specific locations 
	 * under web application root, the classpath, and others.
     */
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }
 
	/* configureDefaultServletHandling
	 * Configure a handler to delegate(대리) unhandled requests by forwarding to the Servlet container's "default" servlet.
	 * */
	
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
   
    /* addViewControllers
     * Configure simple automated controllers pre-configured with the response status code and/or a view to render 
     * the response body. This is useful in cases where there is no need for custom controller logic -- e.g. render 
     * a home page, perform simple site URL redirects, return a 404 status with HTML content, a 204 with no content, and more.
     * */
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("main");
    }
    
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

}

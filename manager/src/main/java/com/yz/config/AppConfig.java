package com.yz.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;

@Configuration
public class AppConfig{

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/main").setViewName("main");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/user/login");
            }
        };
    }

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        return new ServletListenerRegistrationBean(new MyListener());
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
//        ServletRegistrationBean s = new ServletRegistrationBean();
//        s.setLoadOnStartup(1);
        return new ServletRegistrationBean(new MyServlet(),"/servletInit");
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filter =  new FilterRegistrationBean();
        filter.setFilter(new MyFilter());
        filter.setUrlPatterns(Arrays.asList("/user/login"));
        return filter;
    }

    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setPort(8081);
//                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND,"/templates/4XX.ftl");
//                ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/templates/5XX.ftl");
//                container.addErrorPages(error404Page,error500Page);
            }
        };
    }
}

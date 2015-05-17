package org.vd.portal.support;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.nio.charset.Charset;

@ComponentScan
@Configuration
@EnableAutoConfiguration
public class ApplicationLauncher extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(ApplicationLauncher.class, args);
    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }
}

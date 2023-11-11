package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.example.demo.controller.converter.LabelToPriorityConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        // https://www.baeldung.com/spring-enum-request-param
        // registry.addConverter(String.class, Optional.class, Priority::findByLabel);
        registry.addConverter(new LabelToPriorityConverter());
    }
}

package com.example.Seminar_8.config;

import com.example.Seminar_8.aspect.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.example.Seminar_8")
@EnableAspectJAutoProxy
public class ProjectConfiguration {

    @Bean
    public LoggingAspect assect(){
        return new LoggingAspect();
    }
}

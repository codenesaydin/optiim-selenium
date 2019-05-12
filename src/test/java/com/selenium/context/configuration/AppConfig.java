package com.selenium.context.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.selenium")
@Profile("default")
@PropertySource(value = {"classpath:/log4j.properties"})
public class AppConfig
{
}

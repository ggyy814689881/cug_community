package com.example;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;



@SpringBootApplication
public class ForumTplApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumTplApplication.class, args);
		System.out.println("localhost:8080");
		///res/images/avatar/0.jpg
	}
	@Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
	    yaml.setResources(new ClassPathResource("UserRegInfo.yml"));
        configurer.setProperties(yaml.getObject());
        return configurer;
    }
}

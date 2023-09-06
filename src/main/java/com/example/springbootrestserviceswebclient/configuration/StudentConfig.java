package com.example.springbootrestserviceswebclient.configuration;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class StudentConfig {

    @Value("${departmentservice.base.url}")
    private String departmentBaseUrl;

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(departmentBaseUrl).build();
    }

}

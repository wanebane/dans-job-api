package com.rivaldy.dans.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rivaldy.dans.dto.pattern.JobUrl;
import com.rivaldy.dans.dto.pattern.JwtSecret;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class RestConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    @ConfigurationProperties(prefix = "dans.url.job")
    public Map<String, String> mapUrl(){
        return new HashMap<>();
    }

    @Bean
    @ConfigurationProperties(prefix = "application.jwt")
    public Map<String, Object> mapSecretKey(){
        return new HashMap<>();
    }

    @Bean
    public JobUrl jobUrl(){
        var mapper = new ObjectMapper();
        var render = mapUrl().entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return mapper.convertValue(render, JobUrl.class);
    }

    @Bean
    public JwtSecret jwtSecret(){
        var mapper = new ObjectMapper();
        var render = mapSecretKey().entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return mapper.convertValue(render, JwtSecret.class);
    }
}

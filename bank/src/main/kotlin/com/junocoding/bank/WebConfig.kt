package com.junocoding.bank

import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@EnableWebMvc
@CrossOrigin("*")
class WebConfig:WebMvcConfigurer {
    @Override
    fun addCors(registry: CorsRegistry){
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:4200",)
            .allowCredentials(true)
            .allowedMethods("GET", "POST", "PUT", "DELETE")
    }
}


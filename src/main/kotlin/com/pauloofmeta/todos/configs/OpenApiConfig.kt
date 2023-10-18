package com.pauloofmeta.todos.configs

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {
    @Bean
    fun useOpenAPI(): OpenAPI {
        return OpenAPI()
                .info(Info()
                        .title("Todo API")
                        .description("Api for todo example")
                        .version("1.0"))
    }
}
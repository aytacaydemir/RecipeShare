package com.aytac.recipeshare.swaggerdoc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class SpringdocConfig {

    @Bean
    public OpenAPI baseOpenAPI(){
        return new OpenAPI().info(new Info().title("Recipe Share App")
                .version("1.0.0").
                description("Recipe Share Application, Application Programming Interface Documentation"));
    }
}

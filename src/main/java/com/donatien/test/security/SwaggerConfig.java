package com.donatien.test.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author donatien
 * @created 20/03/2021 - 3:38 AM
 * @project test
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket ( DocumentationType.SWAGGER_2)
            .select()
            .apis( RequestHandlerSelectors.basePackage("com.donatien.test.web"))
            //.paths(PathSelectors.regex("/Produits.*"))
            .build();
    }
}

package com.movieFlix.moviefliex.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.security.config.oauth2.client.CommonOAuth2Provider.GITHUB;

@Configuration
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer"
)
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI() {

        Contact contact = new Contact();
        contact.name("Adriano de Alencar");
        //contact.email("contato.adealencar@gmail.com");
        contact.setUrl("https://github.com/Alencar7");

        Info info = new Info();
        info.title("Movieflix");
        info.version("v1");
        info.description("Aplicacao para gerenciamento de catalogo de filmes.");
        info.contact(contact);

        return new OpenAPI().info(info);
    }
}

package lpdf.ufpa.br.frequencia.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI ()
                .info(new Info().title("Frequência LPDF API")
                .description("API de Frequência para o LPDF.")
                .version("v0.0.1")
                .license(new License().name("UFPA").url("https://compmbio.ufpa.br/")))
                .externalDocs(new ExternalDocumentation()
                .description("Wiki do Projeto no Gitlab")
                .url("https://github.com/alverad-katsuro/frequencia_api"));
    }
}


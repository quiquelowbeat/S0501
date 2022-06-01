package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// Configuración de Swagger
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        // Documentación para Swager
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("API de gestió de catàleg de flors").version("1.0").description(
                        "Exemple de servei Spring Boot RESTful utilitzant springdoc-openapi i OpenAPI 3."));
    }
}


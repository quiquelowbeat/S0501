package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("API Rest connectada a una altra API Rest").version("1.0").description(
                        "Exemple de WebClient: peticions GET, POST, PUT, DELETE d'una API a una altra."));
    }
}


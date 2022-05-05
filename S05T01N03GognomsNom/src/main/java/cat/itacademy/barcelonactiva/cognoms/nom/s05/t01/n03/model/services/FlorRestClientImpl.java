package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.dto.FlorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class FlorRestClientImpl implements FlorRestClient{

    private final WebClient webClient;

    public FlorRestClientImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("http://localhost:9001/flor").build();
    }

    public Mono<ResponseEntity<List<FlorDto>>> getAllFlowers(){
        return webClient.get() // Petición a la otra API Rest
                .uri("/getAll") // Endpoint
                .retrieve() // Recibimos la respuesta
                .toEntityList(FlorDto.class); // Recibimos el ResponseEntity junto con la lista de objetos a mostrar
    }

    public Mono<ResponseEntity<FlorDto>> getFlorById(int id){
        return webClient.get()
                .uri("/getOne/" + id)
                .retrieve()
                .toEntity(FlorDto.class); // Recibimos el ResponseEntity junto con el objeto FlorDto
    }

    public Mono<ResponseEntity<FlorDto>> addFlor(FlorDto florDto){
        return webClient.post()
                .uri("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(FlorDto.dtoReadyToAdd(florDto))
                .retrieve()
                .toEntity(FlorDto.class)
                .onErrorResume(WebClientResponseException.class, // Si hay error 4xx o 5xx, la respuesta es un WebclientResponseException.
                        ex -> ex.getRawStatusCode() == 500 ? Mono.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)) : Mono.error(ex));
                // Canalizamos "WebClientResponseException" a un HttpStatus.
    }

    public Mono<ResponseEntity<FlorDto>> updateFlor(FlorDto florDto){
        return webClient.put()
                .uri("/update")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(FlorDto.dtoReadyToUpdate(florDto))
                .retrieve()
                .toEntity(FlorDto.class)
                .onErrorResume(WebClientResponseException.class,
                        ex -> ex.getRawStatusCode() == 404 ? (Mono.just(new ResponseEntity<>(HttpStatus.NOT_FOUND))) : Mono.error(ex));
    }

    public Mono<ResponseEntity<FlorDto>> deleteFlorById(int id) {
        return webClient.delete()
                .uri("/delete/" + id)
                .retrieve()
                .toEntity(FlorDto.class)
                .onErrorResume(WebClientResponseException.class,
                        ex -> ex.getRawStatusCode() == 404 ? (Mono.just(new ResponseEntity<>(HttpStatus.NOT_FOUND))) : Mono.error(ex));
    }
}

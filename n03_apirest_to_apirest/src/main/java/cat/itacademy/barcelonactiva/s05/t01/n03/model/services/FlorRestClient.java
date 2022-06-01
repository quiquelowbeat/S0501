package cat.itacademy.barcelonactiva.s05.t01.n03.model.services;

import cat.itacademy.barcelonactiva.s05.t01.n03.dto.FlorDto;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.List;

public interface FlorRestClient {
    // Los métodos nos van a devolver un objeto provider de tipo Mono con las ResponseEntities correspondientes de la otra API.
    Mono<ResponseEntity<List<FlorDto>>> getAllFlowers();
    Mono<ResponseEntity<FlorDto>> getFlorById(int id);
    Mono<ResponseEntity<FlorDto>> addFlor(FlorDto florDto);
    Mono<ResponseEntity<FlorDto>> updateFlor(FlorDto florDto);
    Mono<ResponseEntity<FlorDto>> deleteFlorById(int id);
}

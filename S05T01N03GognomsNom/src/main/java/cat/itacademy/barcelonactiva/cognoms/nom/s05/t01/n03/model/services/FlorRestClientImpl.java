package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.dto.FlorDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class FlorRestClientImpl implements FlorRestClient{

    private final WebClient webClient;

    public FlorRestClientImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("http://localhost:9001/flor").build();
    }

    public List<FlorDto> getAllFlowers(){
        return webClient.get()
                .uri("/getAll")
                .retrieve()
                .bodyToFlux(FlorDto.class)
                .collectList()
                .block();

    }

    public FlorDto getFlorById(int id){
        return webClient.get()
                .uri("/getOne/{id}", id)
                .retrieve()
                .bodyToMono(FlorDto.class)
                .block();
    }

    public FlorDto addFlor(FlorDto florDto){
        return webClient.post()
                .uri("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(FlorDto.dtoReadyToAdd(florDto))
                .retrieve()
                .bodyToMono(FlorDto.class)
                .block();

    }

    public FlorDto updateFlor(FlorDto florDto){
        return webClient.put()
                .uri("/update")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(FlorDto.dtoReadyToUpdate(florDto))
                .retrieve()
                .bodyToMono(FlorDto.class)
                .block();
    }

    public void deleteFlorById(int id){
        webClient.delete()
                .uri("/delete/" + id)
                .retrieve()
                .bodyToMono(FlorDto.class)
                .block();
    }
}

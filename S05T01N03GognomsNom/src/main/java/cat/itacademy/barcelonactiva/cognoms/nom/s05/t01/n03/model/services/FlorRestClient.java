package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.dto.FlorDto;

import java.util.List;

public interface FlorRestClient {
    List<FlorDto> getAllFlowers();
    FlorDto getFlorById(int id);
    void addFlor(FlorDto florDto);
    void updateFlor(FlorDto florDto);
    void deleteFlorById(int id);

}

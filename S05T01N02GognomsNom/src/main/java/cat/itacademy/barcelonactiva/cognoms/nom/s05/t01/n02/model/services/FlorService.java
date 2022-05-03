package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.dto.FlorDto;

import java.util.List;

public interface FlorService {

    FlorEntity addFlor(FlorEntity flor);
    boolean updateFlor(FlorEntity flor);
    void deleteFlorByID(int id);
    FlorEntity getOneByID(int id);
    List<FlorEntity> getAllFlors();
    FlorEntity toFlor(FlorDto dto);
    FlorDto toFlorDto(FlorEntity flor);

}

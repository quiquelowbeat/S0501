package cat.itacademy.barcelonactiva.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.s05.t01.n02.model.dto.FlorDto;

import java.util.List;

public interface FlorService {
    FlorDto addFlor(FlorDto dto);
    FlorDto updateFlor(FlorDto dto);
    void deleteFlorByID(int id);
    FlorDto getOneByID(int id);
    List<FlorDto> getAllFlors();
}

package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.dto.FlorDto;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlorServiceImpl implements FlorService{

    @Autowired
    private FlorRepository repo;

    @Override
    public FlorDto addFlor(FlorDto dto) {
        return toFlorDto(repo.save(toFlor(dto)));
    }

    @Override
    public FlorDto updateFlor(FlorDto dto) {
        Optional<FlorEntity> optionalFlor = repo.findById(dto.getPk_FlorID());
        FlorEntity florUpdated = null;
        if(optionalFlor.isPresent()){
            florUpdated = optionalFlor.get();
            florUpdated.setNomFlor(dto.getNomFlor());
            florUpdated.setPaisFlor(dto.getPaisFlor());
        }
        return toFlorDto(repo.save(florUpdated));
    }

    @Override
    public void deleteFlorByID(int id) {
        repo.deleteById(id);
    }

    @Override
    public FlorDto getOneByID(int id) {
        Optional<FlorEntity> optionalFlor = repo.findById(id);
        FlorEntity flor = null;
        if(optionalFlor.isPresent()){
            flor = optionalFlor.get();
        }
        return toFlorDto(flor);
    }

    @Override
    public List<FlorDto> getAllFlors() {
        List<FlorDto> listDto = new ArrayList<>();
        for(FlorEntity flor : repo.findAll()){
            listDto.add(toFlorDto(flor));
        }
        return listDto;
    }

    @Override
    public FlorEntity toFlor(FlorDto dto) {
        FlorEntity flor = new FlorEntity();
        flor.setPk_FlorID(dto.getPk_FlorID());
        flor.setNomFlor(dto.getNomFlor());
        flor.setPaisFlor(dto.getPaisFlor());
        return flor;
    }

    @Override
    public FlorDto toFlorDto(FlorEntity flor) {
        FlorDto florDto = new FlorDto();
        florDto.setPk_FlorID(flor.getPk_FlorID());
        florDto.setNomFlor(flor.getNomFlor());
        florDto.setPaisFlor(flor.getPaisFlor());
        florDto.setTipusFlor(flor.getPaisFlor());
        return florDto;
    }
}

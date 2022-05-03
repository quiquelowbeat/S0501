package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.dto.FlorDto;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlorServiceImpl implements FlorService{

    @Autowired
    private FlorRepository repo;

    @Override
    public FlorEntity addFlor(FlorEntity flor) {
        return repo.save(flor);
    }

    @Override
    public boolean updateFlor(FlorEntity flor) {
        Optional<FlorEntity> optionalFlor = repo.findById(flor.getPk_FlorID());
        FlorEntity florUpdated;
        if(optionalFlor.isPresent()){
            florUpdated = optionalFlor.get();
            florUpdated.setNomFlor(flor.getNomFlor());
            florUpdated.setPaisFlor(flor.getPaisFlor());
            repo.save(florUpdated);
        }
        return optionalFlor.isPresent();
    }

    @Override
    public void deleteFlorByID(int id) {
        repo.deleteById(id);
    }

    @Override
    public FlorEntity getOneByID(int id) {
        Optional<FlorEntity> optionalFlor = repo.findById(id);
        FlorEntity flor = null;
        if(optionalFlor.isPresent()){
            flor = optionalFlor.get();
        }
        return flor;
    }

    @Override
    public List<FlorEntity> getAllFlors() {
        return repo.findAll();
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

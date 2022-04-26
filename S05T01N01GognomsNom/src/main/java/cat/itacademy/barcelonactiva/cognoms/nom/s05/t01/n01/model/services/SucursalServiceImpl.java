package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalServiceImpl implements SucursalService{

    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public void addSucursal(Sucursal sucursal) {
        sucursalRepository.save(sucursal);
    }

    @Override
    public boolean updateSucursal(Sucursal sucursal) {
        Optional<Sucursal> sucursalOptional = sucursalRepository.findById(sucursal.getPk_SucursalID());
        Sucursal sucursalUpdated = null;
        if(sucursalOptional.isPresent()){
            sucursalUpdated = sucursalOptional.get();
            sucursalUpdated.setNomSucursal(sucursal.getNomSucursal());
            sucursalUpdated.setPaisSucursal(sucursal.getPaisSucursal());
            sucursalRepository.save(sucursalUpdated);
        }
        return sucursalOptional.isPresent();
    }

    @Override
    public void deleteSucursalById(int id) {
        sucursalRepository.deleteById(id);
    }

    @Override
    public Sucursal getSucursalById(int id) {
        Optional<Sucursal> sucursalOptional = sucursalRepository.findById(id);
        Sucursal sucursal = null;
        if(sucursalOptional.isPresent()){
            sucursal = sucursalOptional.get();
        }
        return sucursal;
    }

    @Override
    public List<Sucursal> getAllSucursal() {
        return sucursalRepository.findAll();
    }

    @Override
    public Sucursal toSucursal(SucursalDTO dto) {
        Sucursal sucursal = new Sucursal();
        sucursal.setPk_SucursalID(dto.getPk_SucursalID());
        sucursal.setNomSucursal(dto.getNomSucursal());
        sucursal.setPaisSucursal(dto.getPaisSucursal());
        return sucursal;
    }

    @Override
    public SucursalDTO toSucursalDto(Sucursal sucursal) {
        SucursalDTO dto = new SucursalDTO();
        dto.setPk_SucursalID(sucursal.getPk_SucursalID());
        dto.setNomSucursal(sucursal.getNomSucursal());
        dto.setPaisSucursal(sucursal.getPaisSucursal());
        dto.setTipusSucursal(sucursal.getPaisSucursal());
        return dto;
    }
}

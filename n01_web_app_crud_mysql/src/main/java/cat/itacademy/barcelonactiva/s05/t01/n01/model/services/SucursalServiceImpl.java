package cat.itacademy.barcelonactiva.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.s05.t01.n01.model.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SucursalServiceImpl implements SucursalService{

    @Autowired
    private SucursalRepository sucursalRepository;

    // Usamos SucursalDTO como objeto de transmisión entrada y salida en los métodos. La comunicación con la database la
    // hacemos con la entidad Sucursal.
    @Override
    public SucursalDTO addSucursal(SucursalDTO dto) {
        Sucursal sucursal = toSucursal(dto);
        return toSucursalDto(sucursalRepository.save(sucursal));
    }

    @Override
    public SucursalDTO updateSucursal(SucursalDTO dto) {
        // Usamos el objeto contenedor Optional para guardar el objeto que buscamos en la DB.
        Optional<Sucursal> sucursalOptional = sucursalRepository.findById(dto.getPk_SucursalID());
        Sucursal sucursalUpdated = null;
        if(sucursalOptional.isPresent()){
            sucursalUpdated = sucursalOptional.get(); // Nos devuelve el objeto que buscamos y usamos el DTO para actualizar los datos.
            sucursalUpdated.setNomSucursal(dto.getNomSucursal());
            sucursalUpdated.setPaisSucursal(dto.getPaisSucursal());
        }
        return toSucursalDto(sucursalRepository.save(sucursalUpdated));
    }

    @Override
    public void deleteSucursalById(int id) {
        sucursalRepository.deleteById(id);
    }

    @Override
    public SucursalDTO getSucursalById(int id) {
        Optional<Sucursal> sucursalOptional = sucursalRepository.findById(id);
        Sucursal sucursal = null;
        if(sucursalOptional.isPresent()){
            sucursal = sucursalOptional.get();
        }
        return toSucursalDto(sucursal);
    }

    @Override
    public List<SucursalDTO> getAllSucursal() {
        List<SucursalDTO> listDto = new ArrayList<>();
        for(Sucursal sucursal : sucursalRepository.findAll()){
            listDto.add(toSucursalDto(sucursal));
        }
        return listDto;
    }

    // Método para transformar Dto a Entity
    public Sucursal toSucursal(SucursalDTO dto) {
        Sucursal sucursal = new Sucursal();
        sucursal.setPk_SucursalID(dto.getPk_SucursalID());
        sucursal.setNomSucursal(dto.getNomSucursal());
        sucursal.setPaisSucursal(dto.getPaisSucursal());
        return sucursal;
    }

    // Método para transformar Entity a Dto
    public SucursalDTO toSucursalDto(Sucursal sucursal) {
        SucursalDTO dto = new SucursalDTO();
        dto.setPk_SucursalID(sucursal.getPk_SucursalID());
        dto.setNomSucursal(sucursal.getNomSucursal());
        dto.setPaisSucursal(sucursal.getPaisSucursal());
        dto.setTipusSucursal(sucursal.getPaisSucursal());
        return dto;
    }
}

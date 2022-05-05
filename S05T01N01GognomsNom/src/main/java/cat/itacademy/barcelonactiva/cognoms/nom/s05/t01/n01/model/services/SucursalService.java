package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto.SucursalDTO;

import java.util.List;

public interface SucursalService {

    // Métodos a implementar en la capa Service.
    SucursalDTO addSucursal(SucursalDTO dto);
    SucursalDTO updateSucursal(SucursalDTO dto);
    void deleteSucursalById(int id);
    SucursalDTO getSucursalById(int id);
    List<SucursalDTO> getAllSucursal();

}

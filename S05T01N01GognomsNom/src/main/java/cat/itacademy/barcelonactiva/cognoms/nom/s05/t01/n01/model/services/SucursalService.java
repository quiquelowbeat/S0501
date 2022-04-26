package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto.SucursalDTO;

import java.util.List;

public interface SucursalService {

    void addSucursal(Sucursal sucursal);
    boolean updateSucursal(Sucursal sucursal);
    void deleteSucursalById(int id);
    Sucursal getSucursalById(int id);
    List<Sucursal> getAllSucursal();
    Sucursal toSucursal(SucursalDTO dto);
    SucursalDTO toSucursalDto(Sucursal sucursal);

}

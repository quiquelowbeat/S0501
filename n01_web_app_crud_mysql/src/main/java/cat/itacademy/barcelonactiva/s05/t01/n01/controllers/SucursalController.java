package cat.itacademy.barcelonactiva.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.s05.t01.n01.model.services.SucursalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// 4200 es el puerto de Angular. Le damos permiso a solicitar datos al backend.
@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200"})
@RestController
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    private SucursalServiceImpl sucursalService;

    // En esta parte de la app organizamos las llamadas a la API.
    @PostMapping("/add")
    public ResponseEntity<SucursalDTO> add(@RequestBody SucursalDTO dto){
        try{
            // El método sucursalService.addSucursal(dto) además de hacer pasar el DTO al service, devuelve el objeto guardado.
            return new ResponseEntity<>(sucursalService.addSucursal(dto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<SucursalDTO> update(@RequestBody SucursalDTO dto){
       try{
            return new ResponseEntity<>(sucursalService.updateSucursal(dto), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
        try{
            sucursalService.deleteSucursalById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<SucursalDTO> getOne(@PathVariable("id") int id){
        try{
            return new ResponseEntity<>(sucursalService.getSucursalById(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SucursalDTO>> getAll(){
        List<SucursalDTO> listDto = new ArrayList<>(sucursalService.getAllSucursal());
        if(listDto.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listDto, HttpStatus.OK);
        }
    }
}

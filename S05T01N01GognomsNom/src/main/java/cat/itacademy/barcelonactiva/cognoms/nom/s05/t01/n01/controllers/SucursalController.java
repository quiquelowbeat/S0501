package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.services.SucursalServiceImpl;
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

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody SucursalDTO dto){
        try{
            sucursalService.addSucursal(sucursalService.toSucursal(dto));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> update(@RequestBody SucursalDTO dto){
        if(sucursalService.updateSucursal(sucursalService.toSucursal(dto))){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
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
            SucursalDTO dto = sucursalService.toSucursalDto(sucursalService.getSucursalById(id));
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SucursalDTO>> getAll(){
        List<SucursalDTO> listDto = new ArrayList<>();
        for(Sucursal sucursal : sucursalService.getAllSucursal()){
            listDto.add(sucursalService.toSucursalDto(sucursal));
        }
        if(listDto.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listDto, HttpStatus.OK);
        }
    }
}

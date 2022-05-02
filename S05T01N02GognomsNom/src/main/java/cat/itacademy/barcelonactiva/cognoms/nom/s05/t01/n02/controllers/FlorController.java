package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.controllers;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.dto.FlorDto;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.services.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/flor")
@CrossOrigin(origins = "http://localhost:9001" )
public class FlorController {

    @Autowired
    private FlorService florService;

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody FlorDto dto){
        try{
            florService.addFlor(florService.toFlor(dto));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> update(@RequestBody FlorDto dto){
        if(florService.updateFlor(florService.toFlor(dto))){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
        try{
            florService.deleteFlorByID(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<FlorDto> getOne(@PathVariable("id") int id){
        try{
            FlorDto dto = florService.toFlorDto(florService.getOneByID(id));
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<FlorDto>> getAll(){
        List<FlorDto> listDto = new ArrayList<>();
        for(FlorEntity flor : florService.getAllFlors()){
            listDto.add(florService.toFlorDto(flor));
        }
        if(listDto.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listDto, HttpStatus.OK);
        }
    }
}

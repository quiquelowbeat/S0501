package cat.itacademy.barcelonactiva.s05.t01.n02.controllers;

import cat.itacademy.barcelonactiva.s05.t01.n02.model.dto.FlorDto;
import cat.itacademy.barcelonactiva.s05.t01.n02.model.services.FlorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/flor")
@CrossOrigin(origins = {"http://localhost:9001", "http://localhost:9002"} )
public class FlorController {

    @Autowired
    private FlorService florService;

    // Anotaciones para la documentación en Swagger (@Operation / @ApiResponses)
    @Operation(summary = "Afegir una nova flor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Flor afegida correctament"),
            @ApiResponse(responseCode = "500", description = "Error al afegir nova flor")})
    @PostMapping("/add")
    public ResponseEntity<FlorDto> add(@RequestBody FlorDto dto){
        try{
            return new ResponseEntity<>(florService.addFlor(dto), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Actualizar la informació d'una flor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Flor actualizada correctament"),
            @ApiResponse(responseCode = "404", description = "Flor no trobada")})
    @PutMapping("/update")
    public ResponseEntity<FlorDto> update(@RequestBody FlorDto dto){
        try{
            return new ResponseEntity<>(florService.updateFlor(dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Esborrar flor per identificador (id)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Flor esborrada correctament"),
            @ApiResponse(responseCode = "404", description = "Flor no trobada")})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@Parameter(description = "id de la flor a esborrar") @PathVariable("id") int id){
        try{
            florService.deleteFlorByID(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Cercar flor per identificaor (id)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Flor trobada correctament",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FlorDto.class))}),
            @ApiResponse(responseCode = "204", description = "Flor no trobada")})
    @GetMapping("/getOne/{id}")
    public ResponseEntity<FlorDto> getOne(@Parameter(description = "id de la flor a cercar")@PathVariable("id") int id){
        try{
            return new ResponseEntity<>(florService.getOneByID(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Retornar tot el catàleg de flors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mostra tot el llistat de flors",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class))}),
            @ApiResponse(responseCode = "204", description = "Llista de flors buida")})
    @GetMapping("/getAll")
    public ResponseEntity<List<FlorDto>> getAll(){
        List<FlorDto> listDto = new ArrayList<>(florService.getAllFlors());
        if(listDto.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listDto, HttpStatus.OK);
        }
    }
}

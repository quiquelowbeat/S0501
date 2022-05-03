package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.controllers;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.dto.FlorDto;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.model.services.FlorRestClientImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flor")
@CrossOrigin(origins = "http://localhost:9002")
public class FlorRestController {

    @Autowired
    private FlorRestClientImpl florRestClientImpl;

    @Operation(summary = "Afegir una nova flor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Flor afegida correctament"),
            @ApiResponse(responseCode = "500", description = "Error al afegir nova flor")})
    @PostMapping("/clientFlorsAdd")
    public ResponseEntity<HttpStatus> add(@RequestBody FlorDto dto){
        try{
            florRestClientImpl.addFlor(dto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Actualizar la informació d'una flor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Flor actualizada correctament"),
            @ApiResponse(responseCode = "404", description = "Flor no trobada")})
    @PutMapping("/clientFlorsUpdate")
    public ResponseEntity<HttpStatus> update(@RequestBody FlorDto dto){
        florRestClientImpl.updateFlor(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Esborrar flor per identificador (id)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Flor esborrada correctament"),
            @ApiResponse(responseCode = "404", description = "Flor no trobada")})
    @DeleteMapping("/clientFlorsDelete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
        try{
            florRestClientImpl.deleteFlorById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Retornar tot el catàleg de flors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mostra tot el llistat de flors",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class))}),
            @ApiResponse(responseCode = "204", description = "Llista de flors buida")})
    @GetMapping("/clientFlorsAll")
    public ResponseEntity<List<FlorDto>> getAll(){
        if(florRestClientImpl.getAllFlowers().isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(florRestClientImpl.getAllFlowers(), HttpStatus.OK);
        }
    }

    @Operation(summary = "Cercar flor per identificaor (id)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Flor trobada correctament",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FlorDto.class))}),
            @ApiResponse(responseCode = "204", description = "Flor no trobada")})
    @GetMapping("clientFlorsGetOne/{id}")
    public ResponseEntity<FlorDto> getOne(@PathVariable("id") int id){
        FlorDto dto = florRestClientImpl.getFlorById(id);
        if(dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
}

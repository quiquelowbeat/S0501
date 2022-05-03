package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.controllers;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.dto.FlorDto;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.model.services.FlorRestClientImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
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
    public FlorDto add(@RequestBody FlorDto dto){
        return florRestClientImpl.addFlor(dto);
    }

    @Operation(summary = "Actualizar la informació d'una flor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Flor actualizada correctament"),
            @ApiResponse(responseCode = "404", description = "Flor no trobada")})
    @PutMapping("/clientFlorsUpdate")
    public FlorDto update(@RequestBody FlorDto dto){
        return florRestClientImpl.updateFlor(dto);
    }

    @Operation(summary = "Esborrar flor per identificador (id)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Flor esborrada correctament"),
            @ApiResponse(responseCode = "404", description = "Flor no trobada")})
    @DeleteMapping("/clientFlorsDelete/{id}")
    public void delete(@PathVariable("id") int id){
        florRestClientImpl.deleteFlorById(id);
    }

    @Operation(summary = "Retornar tot el catàleg de flors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mostra tot el llistat de flors",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class))}),
            @ApiResponse(responseCode = "204", description = "Llista de flors buida")})
    @GetMapping("/clientFlorsAll")
    public List<FlorDto> getAll(){
        return florRestClientImpl.getAllFlowers();
    }

    @Operation(summary = "Cercar flor per identificaor (id)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Flor trobada correctament",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FlorDto.class))}),
            @ApiResponse(responseCode = "204", description = "Flor no trobada")})
    @GetMapping("clientFlorsGetOne/{id}")
    public FlorDto getOne(@PathVariable("id") int id){
        return florRestClientImpl.getFlorById(id);
    }
}
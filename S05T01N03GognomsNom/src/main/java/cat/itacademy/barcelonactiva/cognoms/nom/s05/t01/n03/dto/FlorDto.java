package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlorDto implements Serializable {

    @Schema(description = "Identificador de la flor.")
    private int pk_FlorID;
    @Schema(description = "Nom de la flor.")
    private String nomFlor;
    @Schema(description = "País de la flor.")
    private String paisFlor;
    @Schema(description = "Flor de la UE o de fora.")
    private String tipusFlor;

}

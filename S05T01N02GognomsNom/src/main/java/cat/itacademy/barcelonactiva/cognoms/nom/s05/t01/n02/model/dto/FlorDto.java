package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
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

    // Método para asignar el tipos de pais de la flor
    public void setTipusFlor(String paisFlor){
        this.tipusFlor = PaisosUE.setPaisFlor(paisFlor);
    }
}

package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

import static cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.dto.PaisosUE.paisosUE;

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

    public void setTipusFlor(String paisFlor){
        boolean exist = false;
        int i = 0;
        int loopLength = paisosUE.size();
        while(!exist && i < loopLength){
            if(paisFlor.equalsIgnoreCase(paisosUE.get(i))){
                exist = true;
            }
            i++;
        }
        this.tipusFlor = (exist) ? "UE" : "Fora UE";
    }

}

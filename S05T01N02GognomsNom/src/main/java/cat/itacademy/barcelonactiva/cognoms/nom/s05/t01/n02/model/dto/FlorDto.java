package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.dto;

import static cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.dto.PaisosUE.paisosUE;
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

    private int pk_FlorID;
    private String nomFlor;
    private String paisFlor;
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

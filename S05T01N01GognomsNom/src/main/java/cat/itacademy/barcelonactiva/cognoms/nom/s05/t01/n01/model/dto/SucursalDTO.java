package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto;

import static cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto.PaisosUE.paisosUE;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SucursalDTO implements Serializable {

    private int pk_SucursalID;
    private String nomSucursal;
    private String paisSucursal;
    private String tipusSucursal;

    public void setTipusSucursal(String paisSucursal) {
        boolean exist = false;
        int i = 0;
        int loopLength = paisosUE.size();
        while(!exist && i < loopLength){
            if(paisosUE.get(i).equalsIgnoreCase(paisSucursal)){
                exist = true;
            }
            i++;
        }
        this.tipusSucursal = (exist) ? "UE" : "Fora UE";
    }
}

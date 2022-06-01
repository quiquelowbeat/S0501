package cat.itacademy.barcelonactiva.s05.t01.n01.model.dto;

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
        this.tipusSucursal = PaisosUE.setTipusPais(paisSucursal);
    }
}

package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "llista_sucursals")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int pk_SucursalID;
    @Column(name = "nom_sucursal")
    private String nomSucursal;
    @Column(name = "pais_sucursal")
    private String paisSucursal;

}

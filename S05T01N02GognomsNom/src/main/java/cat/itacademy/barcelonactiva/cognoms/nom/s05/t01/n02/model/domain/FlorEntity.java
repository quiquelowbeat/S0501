package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Table(name = "llistat_flors")
@Entity
public class FlorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_FlorID;
    private String nomFlor;
    private String paisFlor;

}

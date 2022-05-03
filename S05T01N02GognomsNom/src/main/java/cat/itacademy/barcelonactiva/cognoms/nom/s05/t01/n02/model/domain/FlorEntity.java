package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Table(name = "llistat_flors")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FlorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_FlorID;
    private String nomFlor;
    private String paisFlor;


}

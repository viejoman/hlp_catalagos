package corp.galvan.hlp.catalogos.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "hlp_tiposervicios", schema = "desarrollo")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class TipoServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "idtiposervicio", unique = true, nullable = false)
    private Long idtiposervicio;

    @NotNull
    @Column(name = "nombre", length = 60)
    private String nombre;

    @Column(name="descripcion", length = 255)
    private String descripion;

}

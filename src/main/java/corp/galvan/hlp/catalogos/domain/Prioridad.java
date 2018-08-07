package corp.galvan.hlp.catalogos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "hlp_prioridades", schema = "desarrollo")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Prioridad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "idprioridad", unique = true, nullable = false)
    private Long idprioridad;

    @Column(name = "clave")
    private String clave;

    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Column(name = "tiempocontacto")
    private Integer tiempocontacto;

    @NotNull
    @Column(name = "tiemporespuesta")
    private Integer tiemporespuesta;

    @NotNull
    @Column(name = "tiemporesolver")
    private Integer tiemporesolver;

    @NotNull
    @Column(name = "tiempoescalar")
    private Integer tiempoescalar;

}

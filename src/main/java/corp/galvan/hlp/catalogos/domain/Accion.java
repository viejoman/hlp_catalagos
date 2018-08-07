package corp.galvan.hlp.catalogos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "hlp_acciones", schema = "desarrollo")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Accion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "idaccion", unique = true, nullable = false)
    private Long idaccion;

    @NotNull
    @Column(name="nombre", length = 255)
    private String nombre;

}

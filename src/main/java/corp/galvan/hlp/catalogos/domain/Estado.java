package corp.galvan.hlp.catalogos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "hlp_estados", schema = "desarrollo")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "idestado", unique = true, nullable = false)
    private Long idestado;

    @NotNull
    @Column(name="nombre", length = 60)
    private String nombre;

}

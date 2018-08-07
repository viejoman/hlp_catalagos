package corp.galvan.hlp.catalogos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "hlp_inhibidores", schema = "desarrollo")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Inhibidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "idinhibidor", unique = true, nullable = false)
    private Long idinhibidor;

    @NotNull
    @Column(name = "codigo", length = 10)
    private String codigo;

    @NotNull
    @Column(name="nombre", length = 60)
    private String nombre;

    @NotNull
    @Column(name="idtipoinhibidor")
    private Integer idtipoinhibidor;

}


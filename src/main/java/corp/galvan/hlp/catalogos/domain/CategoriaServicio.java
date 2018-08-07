package corp.galvan.hlp.catalogos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hlp_categoriaservicios", schema = "desarrollo")
@NamedStoredProcedureQuery(
        name = "obtenerCategoriaServicio",
        procedureName = "desarrollo.getcategoriaservicio",
        resultClasses = { CategoriaServicio.class },
        parameters = {
                @StoredProcedureParameter(name="idopcion", mode = ParameterMode.IN, type = Long.class)
        }
)
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "idcategoriaserv", unique = true, nullable = false)
    private Long idcategoriaserv;

    @NotNull
    @Column(name="codigo", length = 15)
    private String codigo;

    @NotNull
    @Column(name="descripcion", length = 250)
    private String descripcion;

    @Column(name="idtipocat")
    private Long idtipocat;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<SubCategoriaServicio> subcategoriasservicio;

}

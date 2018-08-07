package corp.galvan.hlp.catalogos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "hlp_subcategoriaservicios", schema = "desarrollo")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@NamedStoredProcedureQuery(
        name = "obtenerSubCategoriaByIdCategoria",
        procedureName = "desarrollo.getSubCategoriaByIdCategoria",
        resultClasses = { SubCategoriaServicio.class },
        parameters = {
                @StoredProcedureParameter(name="idcategoriaserv", mode = ParameterMode.IN, type = Long.class)
        }
)
public class SubCategoriaServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "idsubcategoriaserv", unique = true, nullable = false)
    private Long idsubcategoriaserv;

    @NotNull
    @Column(name="codigo", length = 15)
    private String codigo;

    @NotNull
    @Column(name="descripcion", length = 250)
    private String descripcion;

    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcategoriaservicio")
    private CategoriaServicio categoriaservicio;
    */

}

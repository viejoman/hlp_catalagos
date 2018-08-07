package corp.galvan.hlp.catalogos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Entity(name="Menu")
@Table(name = "vista", schema = "desarrollo")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@NamedStoredProcedureQuery(
        name = "obtenerMenuByIdGrupo",
        procedureName = "desarrollo.getMenuByIdGrupo",
        resultClasses = { Menu.class },
        parameters = {
                @StoredProcedureParameter(name="idgrupo", mode = ParameterMode.IN, type = Long.class)
        }
)
public class Menu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id", unique = true, nullable = false)
    private Long idmenu;

    @NotNull
    @Column(name="texto", length = 255)
    private String texto;

    @Column(name="vista_padre_id")
    private Long idmenuparent;

    @NotNull
    @Column(name="iconcls", length = 80)
    private String iconcls;

    @NotNull
    @Column(name="classname", length = 100)
    private String classname;

}

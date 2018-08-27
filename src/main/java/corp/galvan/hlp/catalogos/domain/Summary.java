package corp.galvan.hlp.catalogos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Summary")
@NamedStoredProcedureQuery(
        name = "obtenerTicketSummary",
        procedureName = "desarrollo.getticketsummary",
        resultClasses = { Summary.class },
        parameters = {
                @StoredProcedureParameter(name="idgrupo", mode = ParameterMode.IN, type = Long.class),
                @StoredProcedureParameter(name="idusuario", mode = ParameterMode.IN, type = Long.class)
        }
)
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Summary {
    @Id
    private Long idestado;
    private Integer numregistros;
}

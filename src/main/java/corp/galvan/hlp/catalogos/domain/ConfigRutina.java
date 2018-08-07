package corp.galvan.hlp.catalogos.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Oficina")
@NamedStoredProcedureQuery(
        name = "obtenerConfigRutina",
        procedureName = "desarrollo.getconfiguracionrutina",
        resultClasses = { ConfigRutina.class },
        parameters = {
                @StoredProcedureParameter(name="idoficina", mode = ParameterMode.IN, type = Long.class)
        }
)
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ConfigRutina {

    @Id
    private Long idcategoriaserv;
    private Long idtipocat;
    private Long numregistros;

}

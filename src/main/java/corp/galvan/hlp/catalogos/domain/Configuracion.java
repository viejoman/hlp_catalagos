package corp.galvan.hlp.catalogos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor()
@NoArgsConstructor
@ToString
public class Configuracion implements Serializable {

    private String tipo;
    private Object valor;

}


package corp.galvan.hlp.catalogos.model;

import corp.galvan.hlp.catalogos.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel {

    private Boolean success;
    private String message;
    private String code;
    private List<Usuario> data;

}


package corp.galvan.hlp.catalogos.model;

import corp.galvan.hlp.catalogos.domain.Oficina;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class OficinaModel {
    private Boolean success;
    private String message;
    private String code;
    private List<Oficina> data;
}

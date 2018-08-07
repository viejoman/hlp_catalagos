package corp.galvan.hlp.catalogos.model;

import corp.galvan.hlp.catalogos.domain.ConfigRutina;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ConfigRutinaModel {
    private Boolean success;
    private String message;
    private String code;
    private List<ConfigRutina> data;
}

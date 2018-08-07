package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.Estado;
import java.util.List;

public interface EstadoService {
    List<Estado> listAll();

    Estado getById(Long id);

    Estado saveOrUpdate(Estado model);

    void delete(Long id);
}

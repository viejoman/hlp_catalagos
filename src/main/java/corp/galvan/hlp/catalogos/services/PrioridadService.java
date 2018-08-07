package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.Prioridad;
import java.util.List;

public interface PrioridadService {
    List<Prioridad> listAll();

    Prioridad getById(Long id);

    Prioridad saveOrUpdate(Prioridad model);

    void delete(Long id);
}

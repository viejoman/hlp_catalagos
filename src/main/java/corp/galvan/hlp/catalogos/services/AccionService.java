package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.Accion;
import java.util.List;

public interface AccionService {
    List<Accion> listAll();

    Accion getById(Long id);

    Accion saveOrUpdate(Accion model);

    void delete(Long id);
}

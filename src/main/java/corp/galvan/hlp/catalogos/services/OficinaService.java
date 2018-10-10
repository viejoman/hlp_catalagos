package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.Oficina;

import java.util.List;

public interface OficinaService {

    List<Oficina> listAll();

    Oficina getById(Long id);

    Oficina saveOrUpdate(Oficina model);

    void delete(Long id);

}

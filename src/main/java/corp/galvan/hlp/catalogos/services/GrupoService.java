package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.Grupo;

import java.util.List;

public interface GrupoService {

    List<Grupo> listAll();

    Grupo getById(Long id);

    Grupo saveOrUpdate(Grupo model);

    void delete(Long id);

}

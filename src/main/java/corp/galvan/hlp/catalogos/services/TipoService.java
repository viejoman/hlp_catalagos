package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.TipoServicio;

import java.util.List;

public interface TipoService {
    List<TipoServicio> listAll();

    TipoServicio getById(Long id);

    TipoServicio saveOrUpdate(TipoServicio model);

    void delete(Long id);
}

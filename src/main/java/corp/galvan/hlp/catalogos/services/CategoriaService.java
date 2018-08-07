package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.CategoriaServicio;
import corp.galvan.hlp.catalogos.domain.ConfigRutina;

import java.util.List;

public interface CategoriaService {

    List<CategoriaServicio> listAll();

    List<CategoriaServicio> getCategoriaServicioByOpcion(Long p__opcion);

    List<ConfigRutina> getCofiguracionRutina(Long p__oficina);

    CategoriaServicio getById(Long id);

    CategoriaServicio saveOrUpdate(CategoriaServicio model);

    void delete(Long id);

}

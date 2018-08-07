package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.SubCategoriaServicio;
import java.util.List;

public interface SubCategoriaService {
    List<SubCategoriaServicio> listAll();

    SubCategoriaServicio getById(Long id);

    SubCategoriaServicio saveOrUpdate(SubCategoriaServicio model);

    void delete(Long id);

    List<SubCategoriaServicio> getSubCategoriaByIdCategoria(Long p_IdCategoriaServ);

}

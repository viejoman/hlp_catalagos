package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.CategoriaServicio;
import corp.galvan.hlp.catalogos.domain.ConfigRutina;
import corp.galvan.hlp.catalogos.repositories.CategoriaServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @PersistenceContext
    private EntityManager _entityManager;


    private CategoriaServicioRepository _categoriaServiceRepository;

    @Autowired
    public CategoriaServiceImpl(CategoriaServicioRepository p__categoriaServiceRepository) {
        this._categoriaServiceRepository = p__categoriaServiceRepository;
    }

    @Override
    public List<CategoriaServicio> listAll() {
        List<CategoriaServicio> _listAux = new ArrayList<>();
        _categoriaServiceRepository.findAll().forEach(_listAux::add);
        return _listAux;
    }

    public List<CategoriaServicio> getCategoriaServicioByOpcion(Long p__opcion) {

        StoredProcedureQuery q = _entityManager.createNamedStoredProcedureQuery("obtenerCategoriaServicio");
        q.setParameter("idopcion", p__opcion);

        List<CategoriaServicio> _listAux = q.getResultList();

        return _listAux;
    }

    public List<ConfigRutina> getCofiguracionRutina(Long p__oficina) {
        StoredProcedureQuery q = _entityManager.createNamedStoredProcedureQuery("obtenerConfigRutina");
        q.setParameter("idoficina", p__oficina);

        List<ConfigRutina> _listAux = q.getResultList();

        return _listAux;
    }

    @Override
    public CategoriaServicio getById(Long id) {
        return _categoriaServiceRepository.findById(id).orElse(null);
    }

    @Override
    public CategoriaServicio saveOrUpdate(CategoriaServicio model) {
        _categoriaServiceRepository.save(model);
        return model;
    }

    @Override
    public void delete(Long id) {
        _categoriaServiceRepository.deleteById(id);

    }

}

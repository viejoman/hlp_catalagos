package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.SubCategoriaServicio;
import corp.galvan.hlp.catalogos.repositories.SubCategoriaServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubCategoriaServiceImpl implements SubCategoriaService {

    @PersistenceContext
    private EntityManager _entityManager;

    private SubCategoriaServicioRepository _subCategoriaRepository;

    @Autowired
    public SubCategoriaServiceImpl(SubCategoriaServicioRepository p__subCategoriaRepository) {
        this._subCategoriaRepository = p__subCategoriaRepository;
    }

    @Override
    public List<SubCategoriaServicio> listAll() {
        List<SubCategoriaServicio> _inhibidores = new ArrayList<>();
        _subCategoriaRepository.findAll().forEach(_inhibidores::add);
        return _inhibidores;
    }

    @Override
    public SubCategoriaServicio getById(Long id) {
        return _subCategoriaRepository.findById(id).orElse(null);
    }

    @Override
    public SubCategoriaServicio saveOrUpdate(SubCategoriaServicio model) {
        _subCategoriaRepository.save(model);
        return model;
    }

    @Override
    public void delete(Long id) {
        _subCategoriaRepository.deleteById(id);
    }

    @Override
    public List<SubCategoriaServicio> getSubCategoriaByIdCategoria(Long p_IdCategoriaServ) {
        StoredProcedureQuery q = _entityManager.createNamedStoredProcedureQuery("obtenerSubCategoriaByIdCategoria");
        q.setParameter("idcategoriaserv", p_IdCategoriaServ);
        List<SubCategoriaServicio> _listSubCategoriaTemp = q.getResultList();

        return _listSubCategoriaTemp;
    }

}

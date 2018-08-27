package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.Estado;
import corp.galvan.hlp.catalogos.domain.Summary;
import corp.galvan.hlp.catalogos.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.List;

@Service
public class EstadoServiceImpl implements EstadoService {

    @PersistenceContext
    private EntityManager _entityManager;

    private EstadoRepository _estadoRepository;

    @Autowired
    public EstadoServiceImpl(EstadoRepository p__accionRepository) {
        this._estadoRepository = p__accionRepository;
    }

    @Override
    public List<Estado> listAll() {
        List<Estado> _inhibidores = new ArrayList<>();
        _estadoRepository.findAll().forEach(_inhibidores::add);
        return _inhibidores;
    }

    @Override
    public Estado getById(Long id) {
        return _estadoRepository.findById(id).orElse(null);
    }

    @Override
    public Estado saveOrUpdate(Estado model) {
        _estadoRepository.save(model);
        return model;
    }

    @Override
    public void delete(Long id) {
        _estadoRepository.deleteById(id);
    }

    public List<Summary> getSummary(Long p__idgrupo, Long p__idusuario) {
        StoredProcedureQuery q = _entityManager.createNamedStoredProcedureQuery("obtenerTicketSummary");
        q.setParameter("idgrupo", p__idgrupo);
        q.setParameter("idusuario", p__idusuario);

        List<Summary> _listAux = q.getResultList();

        return _listAux;
    }
}

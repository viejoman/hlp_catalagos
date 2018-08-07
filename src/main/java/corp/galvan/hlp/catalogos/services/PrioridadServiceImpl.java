package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.Prioridad;
import corp.galvan.hlp.catalogos.repositories.PrioridadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrioridadServiceImpl implements PrioridadService {
    private PrioridadRepository _prioridadRepository;

    @Autowired
    public PrioridadServiceImpl(PrioridadRepository p__prioridadRepository) {
        this._prioridadRepository = p__prioridadRepository;
    }

    @Override
    public List<Prioridad> listAll() {
        List<Prioridad> _inhibidores = new ArrayList<>();
        _prioridadRepository.findAll().forEach(_inhibidores::add);
        return _inhibidores;
    }

    @Override
    public Prioridad getById(Long id) {
        return _prioridadRepository.findById(id).orElse(null);
    }

    @Override
    public Prioridad saveOrUpdate(Prioridad model) {
        _prioridadRepository.save(model);
        return model;
    }

    @Override
    public void delete(Long id) {
        _prioridadRepository.deleteById(id);

    }
}

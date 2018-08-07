package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.Accion;
import corp.galvan.hlp.catalogos.repositories.AccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccionServiceImpl implements AccionService {

    private AccionRepository _accionRepository;

    @Autowired
    public AccionServiceImpl(AccionRepository p__accionRepository) {
        this._accionRepository = p__accionRepository;
    }

    @Override
    public List<Accion> listAll() {
        List<Accion> _inhibidores = new ArrayList<>();
        _accionRepository.findAll().forEach(_inhibidores::add);
        return _inhibidores;
    }

    @Override
    public Accion getById(Long id) {
        return _accionRepository.findById(id).orElse(null);
    }

    @Override
    public Accion saveOrUpdate(Accion model) {
        _accionRepository.save(model);
        return model;
    }

    @Override
    public void delete(Long id) {
        _accionRepository.deleteById(id);

    }
}
